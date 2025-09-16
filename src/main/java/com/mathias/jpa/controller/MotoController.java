package com.mathias.jpa.controller;

import com.mathias.jpa.model.Moto;
import com.mathias.jpa.repository.MotoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moto")
public class MotoController {


    private final MotoRepository motoRepository;


    public MotoController(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    @GetMapping
    public List<Moto> getAll() {
        return motoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Moto> getById(Long id) {
        return motoRepository.findById(id);
    }

    @PostMapping
    public Moto create(@RequestBody Moto moto) {
        return motoRepository.save(moto);
    }


    @PutMapping("/{id}")
    public Moto update(Long id, @RequestBody Moto motoAtualizada) {
        return motoRepository.findById(id)
                .map(m -> {
                    m.setMarca(motoAtualizada.getMarca());
                    m.setModelo(motoAtualizada.getModelo());
                    m.setAno(motoAtualizada.getAno());
                    return motoRepository.save(m);
                })
                .orElseGet(() -> {
                    motoAtualizada.setId(id);
                    return motoRepository.save(motoAtualizada);
                });
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        motoRepository.deleteById(id);
    }
}