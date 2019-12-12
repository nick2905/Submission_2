package com.dicoding.filmku.activity;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    private int photo;
    private String name;
    private String Description;
    private String date;
    private String rate;
    private String director;

    private Movies(Parcel in) {
        photo = in.readInt();
        name = in.readString();
        Description = in.readString();
        date = in.readString();
        rate = in.readString();
        director = in.readString();
    }

    Movies(){
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    int getPhoto() {
        return photo;
    }

    void setPhoto(int photo) {
        this.photo = photo;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return Description;
    }

    void setDescription(String description) {
        Description = description;
    }

    String getDate() {
        return date;
    }

    void setDate(String date) {
        this.date = date;
    }

    String getRate() {
        return rate;
    }

    void setRate(String rate) {
        this.rate = rate;
    }

    String getDirector() {
        return director;
    }

    void setDirector(String director) {
        this.director = director;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(photo);
        parcel.writeString(name);
        parcel.writeString(Description);
        parcel.writeString(date);
        parcel.writeString(rate);
        parcel.writeString(director);
    }
}
