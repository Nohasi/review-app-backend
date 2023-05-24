package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReviewMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        Review review = new Review();
        review.setName(rs.getString("user_name"));
        review.setRating(rs.getInt("review_score"));
        review.setDescription(rs.getString("review_details"));
        return review;
    }
    
}
