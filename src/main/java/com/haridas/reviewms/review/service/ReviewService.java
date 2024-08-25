package com.haridas.reviewms.review.service;

import java.util.List;

import com.haridas.reviewms.review.model.Review;

public interface ReviewService {
	List<Review> getAllReviews(Long companyId);

	boolean addReview(Long companyId, Review review);

	Review getReview( Long reviewId);

	boolean updateReview( Long reviewId, Review updatedview);

	boolean deleteReview( Long reviewId);
}
