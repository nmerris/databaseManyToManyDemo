package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    ActorRepository actorRepository;


    @RequestMapping("/")
    public String index(Model model) {

        Actor actor = new Actor();

        actor.setName("Carey Elwes");
        actor.setRealname("Careth Phinneus Elwes");


        Set<Movie> movies = new HashSet<>();
        Movie movie = new Movie();

        movie.setTitle("The Princess Bride");
        movie.setYear(1987);
        movie.setDescription("tale of love and adventure");

        movies.add(movie);


        Movie movie1 = new Movie();


        movie1.setTitle("Robin Hood: Men in Tights");
        movie1.setYear(1993);
        movie1.setDescription("comedic spoof");

        movies.add(movie1);

        actor.setMovies(movies);

        actorRepository.save(actor);


        model.addAttribute("actors", actorRepository.findAll());

        return "index";


    }

}
