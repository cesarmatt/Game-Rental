package com.example.gamerental.library;

import com.example.gamerental.model.Game;
import com.example.gamerental.model.Genre;

import java.util.List;
import java.util.Map;

public interface LibraryService {

    public static LibraryService getService() {
        return new LibraryServiceImpl(true);
    }

    Game searchGameByTitle(String title);
    List<Game> getAllGames();
    Map<Genre, Long> countGamesByGenre();
    List<Game> getGamesByGenre(String genre);
    Map<Integer, Long> countGamesByYear();
}
