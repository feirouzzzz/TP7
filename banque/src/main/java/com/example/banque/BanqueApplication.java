package com.example.banque;

import com.example.banque.entities.Compte;
import com.example.banque.entities.TypeCompte;
import com.example.banque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args -> {
			// Création de 3 comptes avec solde aléatoire et types différents
			compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));

			// Affichage des comptes dans la console pour vérification
			compteRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});
		};
	}
}
