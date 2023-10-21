package com.team.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class FavouriteMovies extends AppCompatActivity {

    private FavouriteMovieViewModel favouriteMovieViewModel;
    private RecyclerView recyclerViewFavouriteMovies;
    private MoviesAdapter moviesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_movies);
        initViews();
        favouriteMovieViewModel = new ViewModelProvider(this)
                .get(FavouriteMovieViewModel.class);

        moviesAdapter = new MoviesAdapter();
        recyclerViewFavouriteMovies.setAdapter(moviesAdapter);

        moviesAdapter.setOnMovieClickListener(new MoviesAdapter.OnMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(
                FavouriteMovies.this,
                    movie
                );
                startActivity(intent);
            }
        });

        recyclerViewFavouriteMovies.setLayoutManager(new GridLayoutManager(this, 2));
        favouriteMovieViewModel.getFavouriteMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                moviesAdapter.setMovies(movies);
            }
        });
    }

    public static Intent newIntent(Context context){
        return new Intent(context, FavouriteMovies.class);
    }

    private void initViews(){
        recyclerViewFavouriteMovies = findViewById(R.id.recyclerViewFavouriteMovies);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_redirect_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mainViewItem){
            Intent intent = MainActivity.newIntent(FavouriteMovies.this);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}