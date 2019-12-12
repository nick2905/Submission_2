package com.dicoding.filmku.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.filmku.R;

public class TvShowActivity extends AppCompatActivity {
    public TextView txtNameTV;
    public TextView txtDescriptionTV;
    public ImageView imgPhotoTV;
    public TextView txtDirectorTV;
    public TextView txtDateTV;
    public TextView txtRateTV;

    public static final String EXTRA_TVSHOW = "extra_tvshow";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Tv Show Detail");
        }


        txtNameTV = findViewById(R.id.tvshow_name);
        txtDescriptionTV = findViewById(R.id.tvshow_description);
        txtDirectorTV = findViewById(R.id.tvshow_director);
        txtDateTV = findViewById(R.id.tvshow_date);
        txtRateTV = findViewById(R.id.tvshow_rate);
        imgPhotoTV = findViewById(R.id.tvshow_photo);


        TVShow tvshow = getIntent().getParcelableExtra(EXTRA_TVSHOW);
        int photo = tvshow.getPhotoTV();
        String nama = tvshow.getNameTV();
        String description = tvshow.getDescriptionTV();
        String director = tvshow.getDirectorTV();
        String date = tvshow.getDateTV();
        String rate = tvshow.getRateTV();

        imgPhotoTV.setImageResource(photo);
        txtNameTV.setText(nama);
        txtDescriptionTV.setText(description);
        txtDirectorTV.setText(director);
        txtDateTV.setText(date);
        txtRateTV.setText(rate);

    }
}
