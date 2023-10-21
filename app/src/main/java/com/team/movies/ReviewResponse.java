package com.team.movies;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ReviewResponse implements Serializable {

    @SerializedName("docs")
    private List<Review> reviewsList;

    public ReviewResponse(List<Review> reviews) {
        this.reviewsList = reviews;
    }

    public List<Review> getReviewsList() {
        return reviewsList;
    }

    @Override
    public String toString() {
        return "ReviewResponse{" +
                "reviews=" + reviewsList +
                '}';
    }
}
