package com.example.demo.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movie;
import com.example.demo.exception.InputValidationException;
import com.example.demo.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	RatingService ratingService;

	@GetMapping(value = "path/api/rest/customer/{id}/rate/{rating}", produces = "application/json")
	public Optional<Movie> cerateCusterRating(@PathVariable("id") Integer id, @PathVariable("rating") Double rating,
			@RequestBody Movie movie) throws InputValidationException {

		if (StringUtils.isEmpty(rating) && rating >= 5) {
			throw new InputValidationException("Invalid input Pass Ratinf shoud be 1 to 5::");
		}

		movie.setId(id);
		movie.setCustomerAverageRating(rating);
		ratingService.cerateCusterRating(movie);

		List<Movie> movieList = ratingService.getMoviedetails();

		return getMaxcustomerAverageRating(movieList);

	}

	private Optional<Movie> getMaxcustomerAverageRating(List<Movie> movieList) {

		return movieList.stream().max(Comparator.comparing(Movie::getCustomerAverageRating));
	}
}
