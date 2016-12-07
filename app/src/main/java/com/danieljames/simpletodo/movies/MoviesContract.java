package com.danieljames.simpletodo.movies;


import android.support.annotation.NonNull;

import com.danieljames.simpletodo.data.Movie;

import java.util.List;

public interface MoviesContract {

    interface View{
        void showProgressIndicator(boolean active);
        void showMovies(List<Movie> moviesList);
        void showMovieDetailId(int movieId);
    }

    interface UserActionListener{
        void loadMovies(boolean forceUpdate);
        void openMovieDetails(@NonNull Movie requstedMovie);
    }
}
