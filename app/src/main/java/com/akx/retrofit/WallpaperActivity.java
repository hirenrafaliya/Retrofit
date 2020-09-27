package com.akx.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.akx.retrofit.adapter.WallpaperAdapter;
import com.akx.retrofit.model.Hits;
import com.akx.retrofit.model.Root;
import com.akx.retrofit.service.PixabayService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WallpaperActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        recyclerView=findViewById(R.id.recyclerView);

        PixabayService pixabayService=RetrofitInstance.getPixabaySerivce();
        Call<Root> call=pixabayService.getAnimalPhotos();

        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Log.d("TAGER", "onResponse: "+response.code());
                List<Hits> hitsList=response.body().getHits();

                WallpaperAdapter wallpaperAdapter=new WallpaperAdapter(WallpaperActivity.this,hitsList);
                StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(wallpaperAdapter);

            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });


    }
}