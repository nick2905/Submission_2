package com.dicoding.filmku.activity;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {
    private int photoTV;
    private String nameTV;
    private String DescriptionTV;
    private String dateTV;
    private String rateTV;
    private String directorTV;

    public TVShow() {
    }

    public int getPhotoTV() {
        return photoTV;
    }

    public void setPhotoTV(int photoTV) {
        this.photoTV = photoTV;
    }

    public String getNameTV() {
        return nameTV;
    }

    public void setNameTV(String nameTV) {
        this.nameTV = nameTV;
    }

    public String getDescriptionTV() {
        return DescriptionTV;
    }

    public void setDescriptionTV(String descriptionTV) {
        DescriptionTV = descriptionTV;
    }

    public String getDateTV() {
        return dateTV;
    }

    public void setDateTV(String dateTV) {
        this.dateTV = dateTV;
    }

    public String getRateTV() {
        return rateTV;
    }

    public void setRateTV(String rateTV) {
        this.rateTV = rateTV;
    }

    public String getDirectorTV() {
        return directorTV;
    }

    public void setDirectorTV(String directorTV) {
        this.directorTV = directorTV;
    }

    public static Creator<TVShow> getCREATOR() {
        return CREATOR;
    }

    protected TVShow(Parcel in) {
        photoTV = in.readInt();
        nameTV = in.readString();
        DescriptionTV = in.readString();
        dateTV = in.readString();
        rateTV = in.readString();
        directorTV = in.readString();
    }

    public static final Creator<TVShow> CREATOR = new Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel in) {
            return new TVShow(in);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(photoTV);
        parcel.writeString(nameTV);
        parcel.writeString(DescriptionTV);
        parcel.writeString(dateTV);
        parcel.writeString(rateTV);
        parcel.writeString(directorTV);
    }
}
