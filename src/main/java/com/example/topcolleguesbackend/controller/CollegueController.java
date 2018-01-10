package com.example.topcolleguesbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.repository.CollegueRepository;

@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class CollegueController {
	@Autowired private CollegueRepository collegueRepo;
	
	@GetMapping
	public List<Collegue> listerCollegues() {
		return this.collegueRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Collegue> createCollegue(@RequestBody Collegue newCollegue) {
		Optional<Collegue> existingCollegue = this.collegueRepo.findByPseudo(newCollegue.getPseudo());
		if (!existingCollegue.isPresent()) {
			collegueRepo.save(newCollegue);
		}
		return collegueRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value="/{pseudo}")
	public Collegue modifierScore(@RequestBody Action action, @PathVariable String pseudo) {
		
		Optional<Collegue> optCol = collegueRepo.findByPseudo(pseudo);
		
		if(optCol.isPresent()) {
			Collegue col = optCol.get();
			if(action.getAction().equals("aimer")) {
				col.setScore(col.getScore() + 10);
			} else if (action.getAction().equals("detester")) {
				col.setScore(col.getScore() - 5);
			}
			collegueRepo.save(col);
			return col;
		} else {
			return null; //FIXME
		}
		
	}
	
}