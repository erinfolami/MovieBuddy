package com.example.moviebuddy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LatestMovieModel {

    public LatestMovieModel(boolean adult, ArrayList<Object> genres, int id, String original_language,
                            String original_title, String overview, String release_date, String vote_average, ArrayList<Object> production_companies, String status) {
        this.adult = adult;
        this.genres = genres;
        this.id = id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.production_companies = production_companies;
        this.status = status;
    }

    public LatestMovieModel(){

    }

    @SerializedName("adult")
    private boolean adult;
    @SerializedName("genres")
    private ArrayList<Object> genres;
    @SerializedName("id")
    private int id;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("vote_average")
    private String vote_average;
    @SerializedName("production_companies")
    private ArrayList<Object> production_companies;
    @SerializedName("status")
    private String status;


    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public ArrayList<Object> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Object> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public ArrayList<Object> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(ArrayList<Object> production_companies) {
        this.production_companies = production_companies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
