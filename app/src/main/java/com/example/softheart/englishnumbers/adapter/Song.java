package com.example.softheart.englishnumbers.adapter;

public class Song {
    String title;
    int music;
    int imageNumber;

    public Song(String title, int music, int imageNumber) {
        this.title = title;
        this.music = music;
        this.imageNumber=imageNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getMusic() {
        return music;
    }
    public int getImageNumber() {
        return imageNumber;
    }
}
