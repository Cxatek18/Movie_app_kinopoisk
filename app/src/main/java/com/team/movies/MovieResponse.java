package com.team.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    /* @SerializedName("docs") -
    говорит retrofit то что он должен ложить
    по ключу из запроса dosc
    складывать в значение movies
    без этого придётся переименовывать переменную
    если работаем с интернетом надо указывать вне зависимости
    такое же название у переменной или другое.
    Потому что будет произведён процесс обсфускации
     */
    @SerializedName("docs")
    private List<Movie> movies;

    public MovieResponse(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movies=" + movies +
                '}';
    }
}
