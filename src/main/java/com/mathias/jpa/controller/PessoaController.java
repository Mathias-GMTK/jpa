package com.mathias.jpa.controller;


import com.mathias.jpa.model.Pessoa;
import com.mathias.jpa.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/pessoa"))
public class PessoaController {
    private  PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }
    @GetMapping
    public List<Pessoa>getAll(){
        return pessoaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Pessoa> getById(Long id){
        return pessoaRepository.findById(id);
    }
    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada){
        return pessoaRepository.findById(id)
        .map(p -> {
            p.setNome(pessoaAtualizada.getNome());
            p.setSobrenome(pessoaAtualizada.getSobrenome());
            p.setCarteira(pessoaAtualizada.getCarteira());
            return pessoaRepository.save(p);
        })
                .orElseGet(() -> {
            pessoaAtualizada.setId(id);
            return pessoaRepository.save(pessoaAtualizada);
        });
    }

    @DeleteMapping("/{id}")
    public  void delete (@PathVariable Long id){
        pessoaRepository.deleteById(id);
    }

}
