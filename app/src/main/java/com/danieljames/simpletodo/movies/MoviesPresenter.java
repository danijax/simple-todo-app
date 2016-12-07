package com.danieljames.simpletodo.movies;


import android.support.annotation.NonNull;

import com.danieljames.simpletodo.data.Movie;
import com.danieljames.simpletodo.data.MovieRepository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class MoviesPresenter implements MoviesContract.UserActionListener {
    private MovieRepository movieRepository;
    private MoviesContract.View moviesView;


    public MoviesPresenter(@NonNull MovieRepository movieRepository, @NonNull MoviesContract.View moviesView) {
        this.movieRepository = checkNotNull(movieRepository, "can not be null");
        this.moviesView = checkNotNull(moviesView, "Cannot be null");
    }

    @Override
    public void loadMovies(boolean forceUpdate) {
        moviesView.showProgressIndicator(true);
        movieRepository.getMovies(new MovieRepository.LoadMoviesCallBack() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                moviesView.showProgressIndicator(false);
                moviesView.showMovies(movies);
            }
        });

    }

    @Override
    public void openMovieDetails(@NonNull Movie requstedMovie) {
        checkNotNull(requstedMovie, "requsted movie cannot be null");
        moviesView.showMovieDetailId(requstedMovie.getId());
    }
}
