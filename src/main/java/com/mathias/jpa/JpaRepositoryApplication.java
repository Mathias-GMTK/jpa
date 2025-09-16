package com.mathias.jpa;

import com.mathias.jpa.model.Carteira;
import com.mathias.jpa.model.Moto;
import com.mathias.jpa.model.Pessoa;
import com.mathias.jpa.repository.CarteiraRepository;
import com.mathias.jpa.repository.MotoRepository;
import com.mathias.jpa.repository.PessoaRepository;
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
	CommandLineRunner run(PessoaRepository PessoaRepo, MotoRepository MotoRepo, CarteiraRepository CarteiraRepo) {
		return args -> {
			// Inserções
			PessoaRepo.save(new Pessoa(null, "João", "Silva"));
			PessoaRepo.save(new Pessoa(null, "Maria", "Oliveira"));
            PessoaRepo.save(new Pessoa(null, "Silvia", "Preta"));
            PessoaRepo.save(new Pessoa(null, "Clara", "Rio"));
            PessoaRepo.save(new Pessoa(null, "Carlos", "josé"));
            PessoaRepo.save(new Pessoa(null, "Joao", "Bala"));

			// Inserções Moto

			MotoRepo.save((new Moto( "Honda","cg 160", 2000)));
            MotoRepo.save((new Moto( "Honda","XR 300", 2010)));
            MotoRepo.save((new Moto( "Honda","Sahara", 2019)));





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