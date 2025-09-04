package com.mathias.jpa;


import jakarta.persistence.Id;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaRepository {

	public static void main(String[] args) {
		SpringApplication.run(JpaRepository.class, args);
	}

	@Bean
	CommandLineRunner run(PessoaRepository repo,MotoRepository motoRepository) {
		return args -> {
			// Inserções
			repo.save(new Pessoa(null, "João", "Silva"));
			repo.save(new Pessoa(null, "Maria", "Oliveira"));
			repo.save((new Moto("Honda","cg 160", "2000"));


			// Select
			System.out.println("Lista de pessoas:");
			repo.findAll().forEach(p ->
					System.out.println(p.getId() + " - " + p.getNome() + " " + p.getSobrenome())
			);
		};
	}


}