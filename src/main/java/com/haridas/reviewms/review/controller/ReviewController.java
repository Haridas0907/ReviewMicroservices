package com.haridas.reviewms.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haridas.reviewms.review.model.Review;
import com.haridas.reviewms.review.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
		boolean isReviewSaved = reviewService.addReview(companyId, review);
		if (isReviewSaved)
			return new ResponseEntity<>("Review Successfully Added", HttpStatus.OK);
		else
			return new ResponseEntity<>("Review not Added", HttpStatus.NOT_FOUND);

	}

	@GetMapping("/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {
		return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
	}

	@PutMapping("/{reviewId}")
	public ResponseEntity<String> updateReview( @PathVariable Long reviewId,
			@RequestBody Review review) {
		boolean isReviewUpdated = reviewService.updateReview(reviewId,review);
		if (isReviewUpdated)
			return new ResponseEntity<>("Review updated Succesfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Review Not updated ", HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/{reviewId}")
	public ResponseEntity<String> deleteReview (@PathVariable Long reviewId) {
		boolean isReviewDeleted = reviewService.deleteReview(reviewId);
		if (isReviewDeleted)
			return new ResponseEntity<>("Review Deleted "
					+ ""
					+ "Succesfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Review Not updated ", HttpStatus.NOT_FOUND);

	}
}