package com.example.moviebuddy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.moviebuddy.R;

import java.util.List;

import com.example.moviebuddy.models.PopularMovieModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.moviebuddy.request.ApiService;
import com.example.moviebuddy.request.MovieApiClient;
import com.example.moviebuddy.utils.credentials;
import com.example.moviebuddy.viewmodels.MovieRecyclerviewModel;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "MainActivity";
    private MovieRecyclerviewModel movieRecyclerviewModel;

    private MovieApiClient movieApiClient;

    private static final String category = "popular";
    public String posterPath;
    private static final String imageConfigurationPath = "https://image.tmdb.org/t/p/w500";

    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = findViewById(R.id.imageView);

        // Create a ViewModel the first time the system calls an activity's onCreate() method.
        // Re-created activities receive the same MyViewModel instance (MovieRecyclerviewModel) created by the first activity.

        movieRecyclerviewModel = new ViewModelProvider(this).get(MovieRecyclerviewModel.class);

        movieApiClient = MovieApiClient.getInstance();
        movieApiClient.callMoviesApi();
//
//            Log.i(tag, "response" + movieApiClient.imageUrl);















//        Log.i(tag,"response" +  MovieApiClient.getInstance().getPopularMovies().getValue() );

//        callListOfMoviesApi(MainActivity.this);


//        Toast.makeText(MainActivity.this, "response" + imageConfigurationPath, Toast.LENGTH_LONG).show();

    }

    // Observing for any data change
//    private void observeAnyChange(){
//        movieRecyclerviewModel.getPopularMovies().observe(this, new Observer<PopularMovieModel>() {
//            @Override
//            public void onChanged(PopularMovieModel popularMovieModels) {
//                // update UI
//
//            }
//        });
//    }




    public void callListOfMoviesApi(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(credentials.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<PopularMovieModel> call = apiService.listOfMovies(category, credentials.ApiKey);


        call.enqueue(new Callback<PopularMovieModel>() {
            @Override
            public void onResponse(Call<PopularMovieModel> call, Response<PopularMovieModel> response) {
                PopularMovieModel result = response.body();

                posterPath = result.getResults().get(0).getPosterPath();
        Toast.makeText(context, "response" + response.body().getResults(), Toast.LENGTH_LONG).show();

                Glide.with(getBaseContext())
                        .load(imageConfigurationPath + posterPath)
                        .into(imageview);

            }

            @Override
            public void onFailure(Call<PopularMovieModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    //This method currently holds the data relevant to building image URLs
    //I Can't find a way to store the fucntion value in a global variable yet
    // so i'll be commenting this method and pass the imageConfigurationPath explicitly for now
//    public void callImageConfigurationApi() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(credentials.BaseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        MovieApi movieApi = retrofit.create(MovieApi.class);
//
//        Call<ImageConfigurationModel> call = movieApi.ImageConfiguration(credentials.ApiKey);
//
//        call.enqueue(new Callback<ImageConfigurationModel>() {
//            @Override
//            public void onResponse(Call<ImageConfigurationModel> call, Response<ImageConfigurationModel> response) {
//                String imageConfigurationBaseUrl = response.body().getImages().getBaseUrl();
//                String imageConfigurationFileSize = response.body().getImages().getPosterSizes().get(4);
//
//                //sets the  Image configuration Path to a global variable
//                imageConfigurationPath = imageConfigurationBaseUrl + imageConfigurationFileSize;
//
//
//            }

//    @Override
//    public void onFailure(Call<ImageConfigurationModel> call, Throwable t) {
//        t.printStackTrace();
//    }
//});


//        }
        }