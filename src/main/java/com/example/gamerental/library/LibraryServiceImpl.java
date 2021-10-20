package com.example.gamerental.library;

import com.example.gamerental.model.Game;
import com.example.gamerental.model.Genre;

import java.util.List;
import java.util.Map;

import static com.example.gamerental.library.GameDAO.DEFAULT_PATH;

public class LibraryServiceImpl implements LibraryService {

    private final GameDAO dao;

    public LibraryServiceImpl(boolean loadLibrary) {
        this.dao = new GameDAO();
        if (loadLibrary) {
            this.dao.loadLibrary(DEFAULT_PATH);
        }
    }


    @Override
    public Game searchGameByTitle(String title) {
        return dao.getGameByTitle(title);
    }

    @Override
    public List<Game> getAllGames() {
        return dao.getAllGames();
    }

    @Override
    public Map<Genre, Long> countGamesByGenre() {
        return dao.countGamesByGenre();
    }

    @Override
    public List<Game> getGamesByGenre(String genre) {
        return dao.getGamesByGenre(genre);
    }

    @Override
    public Map<Integer, Long> countGamesByYear() {
        return dao.countGamesByYear();
    }
}
