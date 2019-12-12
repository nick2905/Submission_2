package com.dicoding.filmku.activity;


import android.content.res.TypedArray;
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
public class TVShowFragment extends Fragment {

    private RecyclerView rvTVShow;
    private ArrayList<TVShow> tvShows;
    private String[] dataNameTV;
    private String[] dataDescriptionTV;
    private String[] dataDirectorTV;
    private String[] dataDateTV;
    private String[] dataRateTV;
    private TypedArray dataPhotoTV;

    private void prepare(){
        dataNameTV = getResources().getStringArray(R.array.tvshow_nama);
        dataDescriptionTV = getResources().getStringArray(R.array.tvshow_description);
        dataDirectorTV = getResources().getStringArray(R.array.tvshow_director);
        dataDateTV = getResources().getStringArray(R.array.tvshow_date);
        dataRateTV = getResources().getStringArray(R.array.tvshow_rate);
        dataPhotoTV = getResources().obtainTypedArray(R.array.tvshow_photo);
    }

    private void addItem(){
        tvShows = new ArrayList<>();

        for (int i = 0; i < dataNameTV.length; i++){
            TVShow film = new TVShow();

            film.setPhotoTV((dataPhotoTV.getResourceId(i, -1)));
            film.setNameTV(dataNameTV[i]);
            film.setDirectorTV(dataDirectorTV[i]);
            film.setDateTV(dataDateTV[i]);
            film.setDescriptionTV(dataDescriptionTV[i]);
            film.setRateTV(dataRateTV[i]);

            tvShows.add(film);
        }
    }



    public TVShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rView = inflater.inflate(R.layout.fragment_tvshow, container,false);
        rvTVShow = rView.findViewById(R.id.rv_fragment_tv_show);
        rvTVShow.setHasFixedSize(true);

        prepare();
        addItem();

        showRecyclerTVShow();
        // Inflate the layout for this fragment
        return rView;
    }

    private void showRecyclerTVShow(){
        rvTVShow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        TVShowAdapter moviesAdapter = new TVShowAdapter(this.getContext());
        moviesAdapter.setMovies(tvShows);
        rvTVShow.setAdapter(moviesAdapter);
    }

}
