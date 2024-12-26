package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.entity.Actor;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    /*
    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") long id, Model model){
        model.addAttribute("movie",movieService.getMovieById(id));
        return "movie-details";
    }*/

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute MovieForm form, BindingResult results){

        if (results.hasErrors()){
            return "add-movie-form";
        }
        Movie movie = new Movie();
        movie.setTitle(form.getTitle());
        movie.setGenre(form.getGenre());
        movie.setDescription(form.getDescription());

        Actor mainActor=new Actor(form.getFirstName(),form.getLastName());
        movie.setMainActor(mainActor);

        movieService.registerMovie(movie);
        return "movie-added";
    }

}
