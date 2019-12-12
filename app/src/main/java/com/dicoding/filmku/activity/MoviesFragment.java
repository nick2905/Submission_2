package com.dicoding.filmku.activity;


import android.content.res.TypedArray;
import android.graphics.Movie;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicoding.filmku.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private RecyclerView rvMovie;
    private ArrayList<Movies> movies;
    private String[] dataName;
    private String[] dataDescription;
    private String[] dataDirector;
    private String[] dataDate;
    private String[] dataRate;
    private TypedArray dataPhoto;


    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataDirector = getResources().getStringArray(R.array.data_director);
        dataDate = getResources().getStringArray(R.array.data_tanggal);
        dataRate = getResources().getStringArray(R.array.data_rate);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            Movies film = new Movies();

            film.setPhoto((dataPhoto.getResourceId(i, -1)));
            film.setName(dataName[i]);
            film.setDirector(dataDirector[i]);
            film.setDate(dataDate[i]);
            film.setDescription(dataDescription[i]);
            film.setRate(dataRate[i]);

            movies.add(film);
        }
    }

    public MoviesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rView = inflater.inflate(R.layout.fragment_movies, container,false);
        rvMovie = rView.findViewById(R.id.rv_fragment_movie);
        rvMovie.setHasFixedSize(true);

        prepare();
        addItem();

        showRecyclerMovie();
        // Inflate the layout for this fragment
        return rView;
    }
    private void showRecyclerMovie(){
        rvMovie.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MoviesAdapter moviesAdapter = new MoviesAdapter(this.getContext());
        moviesAdapter.setMovies(movies);
        rvMovie.setAdapter(moviesAdapter);
    }
}
