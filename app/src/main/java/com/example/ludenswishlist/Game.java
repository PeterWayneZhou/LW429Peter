package com.example.ludenswishlist;

import java.io.Serializable;

public class Game implements Serializable {
    //This is the Game class by Manjun
    public int gameId;
    public int gameId2;
    public String gameName;
    public String genre;
    public String platform;
    public String studio;
    public String releaseDate;
    //public boolean wantToPlay;
    public String bio;
    public int index;

    public Game() {
    }

    //constructor for sharing
    public Game(String gameName, String releaseDate, String platform, int pic) {
        this.gameName = gameName;
        this.releaseDate = releaseDate;
        this.platform = platform;
        this.gameId = pic;
    }


    public String newsLink;

    //constructor for creating the whole array list of games
    public Game(int index, String gameName, String genre, String platform, String studio, String releaseDate, int gameId, int gameId2, String bio, String newsLink) {
        this.index = index;
        this.gameName = gameName;
        this.genre = genre;
        this.platform = platform;
        this.studio = studio;
        this.releaseDate = releaseDate;
        this.gameId = gameId;
        this.gameId2 = gameId2;
        this.bio = bio;
        this.newsLink = newsLink;
    }

    public int getGameId() {
        return gameId;
    }

    public int getGameId2(){return gameId2;}

    public String getNewsLink(){return newsLink;}

    public String getBio(){return bio;}

    public String getGameName() {
        return gameName;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public String getStudio() {
        return studio;
    }

    public String getReleaseDate() {
        return releaseDate;
    }


}
