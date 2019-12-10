package io.agilerules.ratingsdataservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agilerules.ratingsdataservice.model.Rating;
import io.agilerules.ratingsdataservice.model.UserRating;
import io.agilerules.ratingsdataservice.util.environment.InstanceInformationService;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResourceController {
	@Autowired
	private InstanceInformationService containerMetaDataService;
	
	@GetMapping(path = "/")
	public String imUpAndRunning() {
		return "{healthy:true}";
	}

    @RequestMapping("/movies/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId, containerMetaDataService);
        return userRating;

    }

}
