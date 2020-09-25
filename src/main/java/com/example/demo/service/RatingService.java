package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Movie;
import com.example.demo.hsqldbdao.CustomerRatingRepository;

@Component
public class RatingService {

	@Autowired
	CustomerRatingRepository rep;

	public void cerateCusterRating(Movie movie) {
		rep.save(movie);
	}

	public List<Movie> getMoviedetails() {
		return (List<Movie>) rep.findAll();
	}
}
