package com.example.topcolleguesbackend.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.entite.Vote;
import com.example.topcolleguesbackend.repository.VoteRepository;

@CrossOrigin
@RestController
@RequestMapping("/votes")
public class VoteController {
	@Autowired private VoteRepository voteRepo;

	
	@RequestMapping(method = RequestMethod.GET)
	public List<Vote> listVotesSince(@RequestParam(value="since", required=false) Optional<Integer> sinceId) {
		if (sinceId.isPresent()) {
			//return derniersVotes.stream().filter(v -> (v.getId().intValue() >= sinceId.get())).collect(Collectors.toList()) ;			
			return voteRepo.findByIdGreaterThanEqual(sinceId.get());
		} else {
			return voteRepo.findFirst3ByOrderByIdDesc();
		}
	}

	
}