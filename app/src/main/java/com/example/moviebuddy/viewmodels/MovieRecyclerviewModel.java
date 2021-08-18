package com.example.moviebuddy.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviebuddy.models.PopularMovieModel;
import com.example.moviebuddy.repositories.PopularMoviesRepository;

import retrofit2.Response;

public class MovieRecyclerviewModel extends ViewModel {

    private PopularMoviesRepository popularMoviesRepository;

    public MovieRecyclerviewModel() {
        popularMoviesRepository = PopularMoviesRepository.getInstance();
    }

    //this class is used for ViewModel
    // A helper class for the UI controller that is responsible for preparing data for the UI (Activity/Fragment)


    //Gets the Live Data from the repository
    public LiveData<Response<PopularMovieModel>> getPopularMovies() {

        return popularMoviesRepository.getPopularMovies();
    }


}
