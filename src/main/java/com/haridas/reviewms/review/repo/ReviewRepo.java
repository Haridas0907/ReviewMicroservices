package com.haridas.reviewms.review.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haridas.reviewms.review.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

	List<Review> findByCompanyId(Long companyId);

}