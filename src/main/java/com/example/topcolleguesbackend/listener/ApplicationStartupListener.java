package com.example.topcolleguesbackend.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.repository.CollegueRepository;
import com.example.topcolleguesbackend.repository.VoteRepository;



@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {

	public static final String PREFIX_PATH_IMAGES = "../../assets/img/";
	@Autowired
	CollegueRepository collegueRepo;
	VoteRepository voteRepo;
	/**
	 * This event is executed as late as conceivably possible to indicate that the
	 * application is ready to service requests.
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		List<Collegue> collegues = new ArrayList<>();
		collegues.add(new Collegue("Clément",PREFIX_PATH_IMAGES+"clement.jpg",100));
		collegues.add(new Collegue("Mélodie",PREFIX_PATH_IMAGES+"chloe2.jpg",100));
		collegues.add(new Collegue("Sandra",PREFIX_PATH_IMAGES+"cat.jpg",100));
		collegues.add(new Collegue("Alexandre",PREFIX_PATH_IMAGES+"olga.jpg",100));
		collegues.add(new Collegue("Assia",PREFIX_PATH_IMAGES+"max.jpg",100));
		collegues.add(new Collegue("Mohammed",PREFIX_PATH_IMAGES+"beer.png",100));
		collegues.add(new Collegue("Yves",PREFIX_PATH_IMAGES+"yves.jpeg",100));
		collegues.add(new Collegue("Thien Ban",PREFIX_PATH_IMAGES+"musk.jpg",100));
		collegues.add(new Collegue("Rossi","https://media.licdn.com/media/AAEAAQAAAAAAAAdQAAAAJDk1MWNmZDAwLTNiMTgtNDU0NC05NzM5LWY3MjRhMjBmOGM0Yg.jpg",9000));
		collegues.add(new Collegue("Alabama","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Alabama_in_United_States.svg/2000px-Alabama_in_United_States.svg.png",600));
		collegues.add(new Collegue("Colonel Harland Sanders","https://upload.wikimedia.org/wikipedia/fr/thumb/b/bf/KFC_logo.svg/1024px-KFC_logo.svg.png",150000000));
		collegues.add(new Collegue("Ton voisin","http://i0.kym-cdn.com/entries/icons/mobile/000/004/856/ScumbagSteve.jpg", -1000));
		
		collegueRepo.save(collegues);
		
		return;
	}

}