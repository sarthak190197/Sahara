package com.example.android.sahara;

/**
 * Created by HP on 13-Apr-17.
 */

public class Bhajans {
    String song;
    String artist;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Bhajans(String song, String artist) {

        this.song = song;
        this.artist = artist;
    }
}
