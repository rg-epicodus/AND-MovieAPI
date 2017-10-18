package com.example.guest.movieapi.models;


/**
 * Created by Guest on 10/18/17.
 */

public class Movie {
    private String title;
    private int id;
    private String poster_path;
    private double vote_average;
    private int genre_ids;
    private String release_date;
    private String overview;

    public Movie(String title, String poster_path, double vote_average, int genre_ids, String release_date, String overview) {
        this.title = title;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
        this.genre_ids = genre_ids;
        this.release_date = release_date;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public int getGenre_ids() {
        return genre_ids;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOverview() {
        return overview;
    }
}
