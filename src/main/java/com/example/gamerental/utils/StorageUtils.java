package com.example.gamerental.utils;

import com.example.gamerental.model.Game;
import com.example.gamerental.model.Genre;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StorageUtils {
    public static final int INVALID_CSV_FILE_TOKEN_ERROR_CODE = 1;
    public static final int MISSING_CSV_FILE = 2;

    public static List<Game> loadLibrary(Path path) {
        List<Game> library = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                library.add(getGame(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return library;
    }

    static Game getGame(String line) {
        final String[] tokens = line.split(",");
        return new Game(
                getToken(tokens, 0),
                Integer.parseInt(getToken(tokens, 1)),
                Genre.valueOf(getToken(tokens, 2)),
                getToken(tokens, 3));
    }

    static String getToken(String[] tokens, int idx) {
        final String token = tokens[idx];
        if (token == null) {
            throw new IllegalArgumentException(String.format("%d | Found invalid token at index i:%d", INVALID_CSV_FILE_TOKEN_ERROR_CODE, idx));
        }
        return token.trim();
    }
}
