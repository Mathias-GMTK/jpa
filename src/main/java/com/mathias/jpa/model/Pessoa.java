package com.mathias.jpa.model;

import jakarta.persistence.*;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;


    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Carteira carteira;

    public Pessoa() {}

    public  Pessoa(Long id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public Carteira getCarteira() {
        return carteira;}

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
}