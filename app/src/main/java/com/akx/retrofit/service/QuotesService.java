package com.akx.retrofit.service;

import com.akx.retrofit.model.Quotes;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface QuotesService {

    @Headers({"x-rapidapi-host:shayshay.p.rapidapi.com",
    "x-rapidapi-key:aaebe5b08fmshc07e1e2148a7196p12374bjsn0a51fc843b56"})
    @GET("random")
    Call<Quotes> getAllQuotes(@Query("limit") String limit);

}
