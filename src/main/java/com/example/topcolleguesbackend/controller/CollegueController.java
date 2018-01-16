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
import com.example.topcolleguesbackend.entite.Vote;
import com.example.topcolleguesbackend.repository.CollegueRepository;
import com.example.topcolleguesbackend.repository.VoteRepository;

@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class CollegueController {
	@Autowired private CollegueRepository collegueRepo;
	@Autowired private VoteRepository voteRepo;
	
	@GetMapping
	public List<Collegue> listerCollegues() {
		return this.collegueRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Collegue> createCollegue(@RequestBody Collegue newCollegue) {
		Optional<Collegue> existingCollegue = this.collegueRepo.findByPseudo(newCollegue.getPseudo());
		if (!existingCollegue.isPresent()) {
			collegueRepo.save(newCollegue);
			return collegueRepo.findAll();
		} else {
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value="/{pseudo}")
	public Collegue modifierScore(@RequestBody Action action, @PathVariable String pseudo) {
		
		Optional<Collegue> optCol = collegueRepo.findByPseudo(pseudo);
		
		if(optCol.isPresent()) {
			Collegue col = optCol.get();
			
			switch(action.getAction()) {
			case "aimer":
				col.setScore(col.getScore() + 10);
				break;
			case "pasAimer":
				col.setScore(col.getScore() - 5);
				break;
			case "adorer":
				col.setScore(col.getScore() + 25);
				break;
			case "detester":
				col.setScore(col.getScore() - 15);
				break;
			}
			collegueRepo.save(col);
			
			voteRepo.save(new Vote(col, action.getAction(), col.getScore()));
			
			return col;
		} else {
			return null; //FIXME
		}
		
	}
	
}