package com.dicoding.filmku.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.filmku.R;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieAdapterViewHolder> {
    private Context context;
    private ArrayList<Movies> movies;

    public MoviesAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapterViewHolder holder, int position) {
        final Movies movie = movies.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.txtName.setText(movie.getName());
        holder.txtRate.setText(movie.getRate());
        holder.txtDate.setText(movie.getDate());
        holder.txtDirector.setText(movie.getDirector());
        holder.txtDescription.setText(movie.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movieDetailIntent = new Intent(view.getContext(), MovieActivity.class);
                movieDetailIntent.putExtra(MovieActivity.EXTRA_MOVIE, movie);
                view.getContext().startActivity(movieDetailIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtDescription;
        TextView txtDirector;
        TextView txtDate;
        TextView txtRate;
        ImageView imgPhoto;

        public MovieAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_photo);
            txtName = itemView.findViewById(R.id.txt_name);
            txtDescription = itemView.findViewById(R.id.txt_description);
            txtDirector = itemView.findViewById(R.id.txt_director);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtRate = itemView.findViewById(R.id.txt_rate);
        }
    }

}