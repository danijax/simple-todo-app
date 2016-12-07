package com.danieljames.simpletodo.movies;

import com.danieljames.simpletodo.data.Movie;
import com.danieljames.simpletodo.data.MovieRepository;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by danieljames on 12/7/16.
 */
public class MoviesPresenterTest {

    @Mock
    private MovieRepository movieRepository;
    @Mock
    private MoviesContract.View moviesView;
    @Captor
    private ArgumentCaptor<MovieRepository.LoadMoviesCallBack> loadMoviesCallBackArgumentCaptor;

    private List<Movie> movies = Lists.newArrayList(new Movie(), new Movie());
    private MoviesPresenter moviesPresenter;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        moviesPresenter = new MoviesPresenter(movieRepository, moviesView);
    }

    @Test
    public void loadAllMoviesFromRepositoryIntoView(){
        //fail("not yet impplemented");
        moviesPresenter.loadMovies(true);
        verify(moviesView).showProgressIndicator(true);
        verify(movieRepository).getMovies(loadMoviesCallBackArgumentCaptor.capture());
        loadMoviesCallBackArgumentCaptor.getValue().onMoviesLoaded(movies);
        verify(moviesView).showProgressIndicator(false);
        verify(moviesView).showMovies(movies);
    }

    @Test
    public void clickOnMovieShowsMovieDetailsUi(){
        //fail("Not yet implemented");
        Movie movie = new Movie();
        movie.setId(1234);
        moviesPresenter.openMovieDetails(movie);
        verify(moviesView).showMovieDetailId(any(Integer.class));
    }

}