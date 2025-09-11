package com.mathias.jpa;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRepositoryApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PessoaRepository PessoaRepo, MotoRepository MotoRepo) {
		return args -> {
			// Inserções
			PessoaRepo.save(new Pessoa(null, "João", "Silva"));
			PessoaRepo.save(new Pessoa(null, "Maria", "Oliveira"));

			// Inserções Moto

			MotoRepo.save((new Moto( "Honda","cg 160", 2000)));



			// Select e print pessoas
			System.out.println("Lista de pessoas:");
			PessoaRepo.findAll().forEach(p ->
					System.out.println(p.getId() + " - " + p.getNome() + " " + p.getSobrenome())
			);
			System.out.println("Lista de Motos");
			MotoRepo.findAll().forEach(m ->
					System.out.println(m.getMarca()+ " - " + m.getModelo() + " " + m.getAno())
			);
		};
	}


}