package com.team.movies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Review implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("movieId")
    private int movieId;
    @SerializedName("type")
    private String type;
    @SerializedName("review")
    private String review;
    @SerializedName("author")
    private String author;

    public Review(int id, int movieId, String type, String review, String author) {
        this.id = id;
        this.movieId = movieId;
        this.type = type;
        this.review = review;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getType() {
        return type;
    }

    public String getReview() {
        return review;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", type='" + type + '\'' +
                ", review='" + review + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
