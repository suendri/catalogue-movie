package com.suendri.project.suecataloguemovie12.rest;

import com.suendri.project.suecataloguemovie12.model.Items;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    // 9. Sue Interface
    @GET("search/movie?api_key=3c3c8837951d996e1a4aa9c975465ddf&language=en-US")
    Call<Items> getItemSearch(@Query("query") String movie_name);
}
