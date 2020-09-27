package com.akx.retrofit;

import com.akx.retrofit.service.PixabayService;
import com.akx.retrofit.service.QuotesService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    static QuotesService quotesService;
    static PixabayService pixabayService;

    public static QuotesService getQuotesService() {
        if (quotesService == null) {
            Retrofit retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://shayshay.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            quotesService = retrofit.create(QuotesService.class);
        }
        return quotesService;
    }

    public static PixabayService getPixabaySerivce(){
        if(pixabayService==null){
            Retrofit retrofit=new retrofit2.Retrofit.Builder()
                    .baseUrl("https://pixabay.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            pixabayService=retrofit.create(PixabayService.class);
        }
        return pixabayService;
    }
}
