package com.mathias.jpa.controller;

import com.mathias.jpa.model.Carteira;
import com.mathias.jpa.repository.CarteiraRepository;
import org.springframework.web.bind.annotation.*; // Added for clarity
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {

    private final CarteiraRepository carteiraRepository;

    public CarteiraController(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    @GetMapping
    public List<Carteira> getAll(){
        return carteiraRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Carteira> getById(Long id){
        return carteiraRepository.findById(id);
    }

    @PostMapping
    public Carteira create(@RequestBody Carteira carteira){
        return carteiraRepository.save(carteira);
    }

    @PutMapping("/{id}")
    public Carteira update(Long id, @RequestBody Carteira carteiraAtualizada) {
        return carteiraRepository.findById(id)
                .map(f -> {
                    f.setNome(carteiraAtualizada.getNome());
                    f.setNumeroRegistro(carteiraAtualizada.getNumeroRegistro());
                    f.setValidade(carteiraAtualizada.getValidade());
                    return carteiraRepository.save(f);
                })
                .orElseGet(() -> {
                    carteiraAtualizada.setId(id);
                    return carteiraRepository.save(carteiraAtualizada);
                });
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        carteiraRepository.deleteById(id);
    }
}