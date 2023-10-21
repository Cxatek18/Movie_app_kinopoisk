package com.team.movies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.List;


public class FavouriteMovieViewModel extends AndroidViewModel {

    private final MovieDao movieDao;

    public FavouriteMovieViewModel(@NonNull Application application) {
        super(application);
        movieDao = MovieDatabase.getInstance(getApplication()).movieDao();
    }

    public LiveData<List<Movie>> getFavouriteMovies() {
        return movieDao.getAllFavouriteMovies();
    }
}
