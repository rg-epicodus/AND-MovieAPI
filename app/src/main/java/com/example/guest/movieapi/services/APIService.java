package com.example.guest.movieapi.services;

import android.provider.SyncStateContract;
import android.util.Log;

import com.example.guest.movieapi.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 10/18/17.
 */

public class APIService {
    public static void findMovies(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(SyncStateContract.Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(SyncStateContract.Constants.NAME_SEARCH_QUERY_PARAMETER, movieTitle);
        urlBuilder.addQueryParameter(SyncStateContract.Constants.API_KEY_QUERY_PARAMETER, SyncStateContract.Constants.API_KEY);
        String url = urlBuilder.build().toString();
        Log.v("String url", url);
        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject apiJSON = new JSONObject(jsonData);
            JSONArray listJSON = apiJSON.getJSONArray("firstJSONName");
            for (int i = 0; i < listJSON.length(); i++) {
                JSONObject mainJSON = listJSON.getJSONObject(i);
                Movie forecast = new Movie();
                movies.add(forecast);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return movies;
    }
}
