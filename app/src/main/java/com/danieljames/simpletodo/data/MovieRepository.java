package com.danieljames.simpletodo.data;


import java.util.List;

public interface MovieRepository {
    void getMovies(LoadMoviesCallBack callBack);
    void getMovie(GetMovieCallBack callBack);
    void saveMovie(Movie movie);
    void refreshData();

    interface LoadMoviesCallBack{
        void onMoviesLoaded(List<Movie> movies);
    }

    interface GetMovieCallBack {
        void onMovieCallBack(Movie movie);
    }
}
