package com.example.gamerental.library;

import com.example.gamerental.model.Game;
import com.example.gamerental.model.Genre;
import com.example.gamerental.utils.StorageUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameDAO {

    public static Path DEFAULT_PATH = Paths.get("src/main/resources/games.csv");
    private List<Game> library = new ArrayList<>();

    public void loadLibrary(Path path) {
        this.library = StorageUtils.loadLibrary(path);
    }

    public Game getGameByTitle(String title) {
        for (Game game : library) {
            if (game.getTitle().equals(title)) {
                return game;
            }
        }

        return null;
    }

    public List<Game> getAllGames() {
        return this.library;
    }

    public Map<Genre, Long> countGamesByGenre() {
        return library.stream()
                .collect(Collectors.groupingBy(Game::getGenre, Collectors.counting()));
    }

    public List<Game> getGamesByGenre(String genre) {
        List<Game> gamesByGenre = new ArrayList<>();
        for (Game game : library) {
            if (game.getGenre().toString().equals(genre)) {
                gamesByGenre.add(game);
            }
        }

        return gamesByGenre;
    }

    public Map<Integer, Long> countGamesByYear() {
        return library.stream()
                .collect(Collectors.groupingBy(Game::getReleaseYear, Collectors.counting()));
    }
}
