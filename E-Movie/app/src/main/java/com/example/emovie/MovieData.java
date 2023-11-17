package com.example.emovie;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieData implements Parcelable {
    private int picture;
    private int genre;
    private String produser;
    private String sutradara;
    private String penulis;
    private String distribusi;
    private String tayang;
    private String durasi;
    private String txtgenre;
    private String pemeran;
    private String ketSinopsis;
    private String link;

    protected MovieData(Parcel in) {
        picture = in.readInt();
        genre = in.readInt();
        produser = in.readString();
        sutradara = in.readString();
        penulis = in.readString();
        distribusi = in.readString();
        tayang = in.readString();
        durasi = in.readString();
        txtgenre = in.readString();
        pemeran = in.readString();
        ketSinopsis = in.readString();
        link = in.readString();
    }

    public static final Creator<MovieData> CREATOR = new Creator<MovieData>() {
        @Override
        public MovieData createFromParcel(Parcel in) {
            return new MovieData(in);
        }

        @Override
        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };

    public MovieData() {

    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getProduser() {
        return produser;
    }

    public void setProduser(String produser) {
        this.produser = produser;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getDistribusi() {
        return distribusi;
    }

    public void setDistribusi(String distribusi) {
        this.distribusi = distribusi;
    }

    public int getGenre(){ return genre; }

    public void setGenre(int genre) { this.genre = genre; }

    public String getTayang() { return tayang; }

    public void setTayang(String tayang) { this.tayang = tayang; }

    public String getDurasi() { return durasi; }

    public void setDurasi(String durasi) { this.durasi = durasi; }

    public String getTxtgenre() { return txtgenre; }

    public void setTxtgenre(String txtgenre) { this.txtgenre = txtgenre; }

    public String getPemeran() { return pemeran; }

    public void setPemeran(String pemeran) { this.pemeran = pemeran; }

    public String getKetSinopsis() { return ketSinopsis; }

    public void setKetSinopsis(String ketSinopsis) { this.ketSinopsis = ketSinopsis; }

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(picture);
        dest.writeInt(genre);
        dest.writeString(produser);
        dest.writeString(sutradara);
        dest.writeString(penulis);
        dest.writeString(distribusi);
        dest.writeString(tayang);
        dest.writeString(durasi);
        dest.writeString(txtgenre);
        dest.writeString(pemeran);
        dest.writeString(ketSinopsis);
        dest.writeString(link);
    }
}
