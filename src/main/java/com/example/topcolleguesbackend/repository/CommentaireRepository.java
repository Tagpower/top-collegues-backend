package com.example.topcolleguesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.topcolleguesbackend.entite.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

}
