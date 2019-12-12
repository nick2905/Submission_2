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

    public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowAdapterViewHolder>{
    private Context context;
    private ArrayList<TVShow> tvshow;

    public TVShowAdapter(Context context) {
        this.context = context;
        tvshow = new ArrayList<>();
    }

    @NonNull
    @Override
    public TVShowAdapter.TVShowAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tv_show_item, parent, false);
        return new TVShowAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TVShowAdapter.TVShowAdapterViewHolder holder, int position) {
        final TVShow film = tvshow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(film.getPhotoTV())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhotoTV);

        holder.txtNameTV.setText(film.getNameTV());
        holder.txtRateTV.setText(film.getRateTV());
        holder.txtDateTV.setText(film.getDateTV());
        holder.txtDirectorTV.setText(film.getDirectorTV());
        holder.txtDescriptionTV.setText(film.getDescriptionTV());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent movieDetailIntent = new Intent(view.getContext(), TvShowActivity.class);
                movieDetailIntent.putExtra(TvShowActivity.EXTRA_TVSHOW, film);
                view.getContext().startActivity(movieDetailIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return tvshow.size();
    }

    void setMovies(ArrayList<TVShow> tvshow) {
        this.tvshow = tvshow;
    }

    class TVShowAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameTV;
        TextView txtDescriptionTV;
        TextView txtDirectorTV;
        TextView txtDateTV;
        TextView txtRateTV;
        ImageView imgPhotoTV;

        TVShowAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhotoTV = itemView.findViewById(R.id.tvshow_photo);
            txtNameTV = itemView.findViewById(R.id.tvshow_name);
            txtDescriptionTV = itemView.findViewById(R.id.tvshow_description);
            txtDirectorTV = itemView.findViewById(R.id.tvshow_director);
            txtDateTV = itemView.findViewById(R.id.tvshow_date);
            txtRateTV = itemView.findViewById(R.id.tvshow_rate);
        }
    }

}
