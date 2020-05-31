package com.mycompany.dvdstore.web.api;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Scanner;

@RestController
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

    @GetMapping
    public List<Movie> list(){
        return movieService.getMovieList();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") long id){
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.registerMovie(movie);
    }




}
