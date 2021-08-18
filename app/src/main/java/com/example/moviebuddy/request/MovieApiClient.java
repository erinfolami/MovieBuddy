package com.example.moviebuddy.request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviebuddy.executors.AppExecutors;
import com.example.moviebuddy.models.PopularMovieModel;
import com.example.moviebuddy.utils.credentials;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieApiClient {

    //LiveData
    private MutableLiveData<Response<PopularMovieModel>> popularMoviesLiveData;

    public String imageUrl;

    private static MovieApiClient instance;


    private static final String imageConfigurationPath = "https://image.tmdb.org/t/p/w500";
    private static final String category = "popular";
    private static final String tag = "Api_response";


    private MovieApiClient() {
        popularMoviesLiveData = new MutableLiveData<>();
    }


    public static MovieApiClient getInstance() {
        if (instance == null) {
            instance = new MovieApiClient();
        }
        return instance;
    }


    public LiveData<Response<PopularMovieModel>> getPopularMovies() {
        return popularMoviesLiveData;

    }

    public String getImageUrl() {
        return this.imageUrl;

    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;

    }

    public void setPopularMovies(Response<PopularMovieModel> result) {
        popularMoviesLiveData.postValue(result);

    }

    public void callMoviesApi() {

        final Future myHandler = AppExecutors.getInstance().NetworkIo().submit(new Runnable() {
            @Override
            public void run() {
                //(Task)Retries Data from Api

                Log.i(tag, "response" +  callPopularMoviesApi(category));
//                Log.i(tag, "response" + imageUrl);

//                Log.i(tag, "response" + "a");
//                Log.i(tag, "response" + "b");
//                Log.i(tag, "response" + "d");
//                Log.i(tag, "response" + "c");
            }
        });

        AppExecutors.getInstance().NetworkIo().schedule(new Runnable() {
            @Override
            public void run() {
                //Cancels the retrofit call after the given duration,
                //Attempts to cancel execution of this task.
                // This attempt will fail if the task has already completed,
                // has already been cancelled, or could not be cancelled for some other reason.

                myHandler.cancel(true);
            }
        }, 5000, TimeUnit.SECONDS);
    }


    //Retrieving PopularMovies Data from RestApi
    public String callPopularMoviesApi(String category) {

//            String imageUrl = null;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(credentials.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<PopularMovieModel> call = apiService.listOfMovies(category, credentials.ApiKey);


        try {
            //Executing the Api call Synchronously,
            // but doesn't matter because it is executed in background thread
            // using the App Executor class
            Response<PopularMovieModel> response = call.execute();
            String imageUrl = imageConfigurationPath + response.body().getResults().get(0).getPosterPath();
            popularMoviesLiveData.postValue(response);


            setImageUrl(imageUrl);



        } catch (IOException e) {
            e.printStackTrace();
        }
        //returns ImageUrl
        return imageUrl;
    }


}
