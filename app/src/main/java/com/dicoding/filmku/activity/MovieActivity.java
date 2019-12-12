package com.dicoding.filmku.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.filmku.R;

public class MovieActivity extends AppCompatActivity {
    public TextView txtName;
    public TextView txtDescription;
    public ImageView imgPhoto;
    public TextView txtDirector;
    public TextView txtDate;
    public TextView txtRate;

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Movie Detail");
        }

        txtName = findViewById(R.id.txt_name);
        txtDescription = findViewById(R.id.txt_description);
        txtDirector = findViewById(R.id.txt_director);
        txtDate = findViewById(R.id.txt_date);
        txtRate = findViewById(R.id.txt_rate);
        imgPhoto = findViewById(R.id.img_photo);

        Movies movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        int photo = movie.getPhoto();
        String nama = movie.getName();
        String description = movie.getDescription();
        String director = movie.getDirector();
        String date = movie.getDate();
        String rate = movie.getRate();

        imgPhoto.setImageResource(photo);
        txtName.setText(nama);
        txtDescription.setText(description);
        txtDirector.setText(director);
        txtDate.setText(date);
        txtRate.setText(rate);

    }

}
