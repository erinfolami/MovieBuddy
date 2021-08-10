package com.example.moviebuddy.utils;

import com.example.moviebuddy.models.ImageConfigurationModel;
import com.example.moviebuddy.models.PopularMovieModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("/3/movie/{category}")
    Call<PopularMovieModel> listOfMovies(
            @Path("category") String category,
            @Query("api_key") String api_key
    );


    @GET("/3/configuration")
    Call<ImageConfigurationModel> ImageConfiguration(
                @Query("api_key") String api_key
        );



}

