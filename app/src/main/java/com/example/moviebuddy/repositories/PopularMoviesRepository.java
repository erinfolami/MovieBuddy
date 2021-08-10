package com.example.moviebuddy.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import com.example.moviebuddy.models.PopularMovieModel;

public class PopularMoviesRepository {
    //A class for providing Api for accessing Popular Movies data

    //This class will be Implementing the Singleton Pattern
    // so that the class can have only one instance, to prevent: memory leak etc


    private static PopularMoviesRepository instance;

    //LiveData
    private MutableLiveData<List<PopularMovieModel>> PopularMoviesLiveData;



    private PopularMoviesRepository(){
       this.PopularMoviesLiveData = new MutableLiveData<>();
    }



    public static PopularMoviesRepository getInstance() {
        if (instance == null) {
            instance = new PopularMoviesRepository();
        }
        return instance;
    }


    public LiveData<List<PopularMovieModel>> getPopularMovies () {
        return PopularMoviesLiveData;
    }

}
