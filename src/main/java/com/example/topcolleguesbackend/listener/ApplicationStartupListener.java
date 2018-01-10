package com.example.topcolleguesbackend.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.repository.CollegueRepository;


@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	CollegueRepository collegueRepo;
	/**
	 * This event is executed as late as conceivably possible to indicate that the
	 * application is ready to service requests.
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		List<Collegue> collegues = new ArrayList<>();
		collegues.add(new Collegue("Clément","clement.jpg",100));
		collegues.add(new Collegue("Mélodie","chloe2.jpg",100));
		collegues.add(new Collegue("Sandra","cat.jpg",100));
		collegues.add(new Collegue("Alexandre","olga.png",100));
		collegues.add(new Collegue("Assia","max.png",100));
		collegues.add(new Collegue("Mohammed","beer.png",100));
		collegues.add(new Collegue("Yves","yves.jpg",100));
		collegues.add(new Collegue("Thien-Ban","musk.jpg",100));
		collegueRepo.save(collegues);
		
		return;
	}

}