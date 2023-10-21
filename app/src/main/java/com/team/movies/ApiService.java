package com.team.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    /*
    С помощью анотации Query - мы можем передовать параметры внутрь запроса
     */
//    @GET("https://api.kinopoisk.dev/v1.3/movie?token=B2SXF89-ECEMA1W-NQP8VJW-YHT94HH&sortField=rating.kp&rating.kp=7-10&sortField=votes.kp&sortType=-1&limit=5")
    @GET("v1.3/movie?token=B2SXF89-ECEMA1W-NQP8VJW-YHT94HH&rating.kp=4-8&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(
            @Query("page") int page
    );

    @GET("https://api.kinopoisk.dev/v1.3/movie/{idFilms}?token=B2SXF89-ECEMA1W-NQP8VJW-YHT94HH")
    Single<TrailerResponse> loadTrailers(@Path("idFilms") int id);

    @GET("https://api.kinopoisk.dev/v1/review?page=1&limit=10&token=B2SXF89-ECEMA1W-NQP8VJW-YHT94HH")
    Single<ReviewResponse> loadReviews(@Query("movieId") String id);
}
