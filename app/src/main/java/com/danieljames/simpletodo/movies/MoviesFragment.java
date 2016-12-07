package com.danieljames.simpletodo.movies;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danieljames.simpletodo.data.Movie;

import java.util.List;

public class MoviesFragment extends Fragment implements MoviesContract.View{

    private MoviesContract.UserActionListener userActionListener;

    public MoviesFragment() {
    }

    public static MoviesFragment newInstance(){
        return new MoviesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showProgressIndicator(boolean active) {

    }

    @Override
    public void showMovies(List<Movie> moviesList) {

    }

    @Override
    public void showMovieDetailId(int movieId) {

    }
}
