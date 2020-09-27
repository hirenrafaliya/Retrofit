package com.akx.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.akx.retrofit.adapter.QuotesAdapter;
import com.akx.retrofit.model.Quotes;
import com.akx.retrofit.service.QuotesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuotesActivity extends AppCompatActivity {
    String TAG="TAGER";

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        recyclerView=findViewById(R.id.recyclerView);

        QuotesService quotesService=RetrofitInstance.getQuotesService();

        Call<Quotes> call =quotesService.getAllQuotes("20");

        call.enqueue(new Callback<Quotes>() {
            @Override
            public void onResponse(Call<Quotes> call, Response<Quotes> response) {
                List<String> quoteList=response.body().getQuotes();
                QuotesAdapter adapter=new QuotesAdapter(quoteList);
                recyclerView.setLayoutManager(new LinearLayoutManager(QuotesActivity.this));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Quotes> call, Throwable t) {

            }
        });


    }
}