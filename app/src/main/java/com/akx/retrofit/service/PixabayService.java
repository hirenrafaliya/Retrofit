package com.akx.retrofit.service;


import com.akx.retrofit.model.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PixabayService {


    @GET("?key=4730362-f0ac2085740907878176e1fbc&category=nature")
    Call<Root> getAnimalPhotos();
}
