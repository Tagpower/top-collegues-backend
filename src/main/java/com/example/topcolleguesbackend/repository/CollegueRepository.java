package com.example.topcolleguesbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.topcolleguesbackend.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	Optional<Collegue> findByPseudo(String pseudo); 
	
}
