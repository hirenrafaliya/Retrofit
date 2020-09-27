package com.akx.retrofit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akx.retrofit.model.Post;
import com.akx.retrofit.service.JsonPlaceHolderService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="TAGER";

    Button btnGetAllPosts,btnSet;
    TextView txtResponse;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetAllPosts = findViewById(R.id.btnGet);
        btnSet = findViewById(R.id.btnSet);
        txtResponse = findViewById(R.id.txtResponse);


        JsonPlaceHolderService jsonPlaceHolderService = JsonPlaceHolderService.create();
        final Call<Post> call = jsonPlaceHolderService.getPostById("4");


        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post post = new Post(1, 11, "Test title", "Test body");

                Call<Post> call = jsonPlaceHolderService.setPost(post);
                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Gson gson = new Gson();
                        String s = gson.toJson(response.body());
                        Log.d(TAG, "onResponse: " + s);
                        txtResponse.setText(s);
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");
                    }
                });
            }
        });

        btnGetAllPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {

                        Post post = response.body();
                        StringBuilder builder = new StringBuilder();
                        builder.append("Id : " + post.id + "\n");
                        builder.append("Title : " + post.getTitle() + "\n");
                        builder.append("Body : " + post.getBody() + "\n\n");

                        txtResponse.setText(builder.toString());
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {

                    }
                });
            }
        });


    }
}


