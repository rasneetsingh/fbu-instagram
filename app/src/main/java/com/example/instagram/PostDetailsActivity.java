package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

public class PostDetailsActivity extends AppCompatActivity {

    TextView tvUsername;
    TextView tvDescription;
    ImageView ivImage;


    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);


        findViewById(R.id.btnback).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();

            }
        });
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        // unwrap the movie passed in via intent, using its simple name as a key
        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));
        Log.d("PostDetailsActivity", String.format("Showing details for '%s'", post.getUser()));
        Log.d("PostDetailsActivity", String.format("Showing details for '%s'", post.getDescription()));
        Log.d("PostDetailsActivity", String.format("Showing details for '%s'", post.getImage()));



        //tvUsername.setText(post.getUser());
        tvDescription.setText(post.getDescription());

        ParseFile image = post.getImage();
        if (image != null) {
            Glide.with(PostDetailsActivity.this).load(image.getUrl()).into(ivImage);
        }





    }
}