package com.mathias.jpa;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Carteira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String numeroRegistro;
    private LocalDate validade;


    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa Pessoa;

    @OneToMany(mappedBy = "Carteira", cascade = CascadeType.ALL)
    private List<Moto> motos;

    public Carteira(){}

    public Carteira(Long id, String nome, String numeroRegistro, LocalDate validade) {
        this.id = id;
        this.nome = nome;
        this.numeroRegistro = numeroRegistro;
        this.validade = validade;
        this.pessoa = pessoa;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        validade = validade;
    }

    public Pessoa getPessoa() {
        return Pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        Pessoa = pessoa;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }
}
