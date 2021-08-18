package com.example.moviebuddy.repositories;

import androidx.lifecycle.LiveData;

import com.example.moviebuddy.models.PopularMovieModel;
import com.example.moviebuddy.request.MovieApiClient;

import retrofit2.Response;

public class PopularMoviesRepository {
    //A class for providing Api for accessing Popular Movies data

    //This class will be Implementing the Singleton Pattern
    // so that the class can have only one instance of the PopularMoviesRepository object,
    // to prevent: memory leak,optimize memory resource etc


    private static PopularMoviesRepository instance;

    private MovieApiClient movieApiClient;

//    private PopularMoviesRepository() {
//        this.movieApiClient = new;
//    }


    public static PopularMoviesRepository getInstance() {
        if (instance == null) {
            instance = new PopularMoviesRepository();
        }
        return instance;
    }


    public LiveData<Response<PopularMovieModel>> getPopularMovies() {

        return MovieApiClient.getInstance().getPopularMovies();

    }

}
