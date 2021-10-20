package com.example.gamerental.model;

public class Game {

    private final String title;
    private final int releaseYear;
    private final Genre genre;
    private final String publisher;

    public Game(String title, int releaseYear, Genre genre, String publisher) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }
}
