package com.example.gamerental.utils;

import com.example.gamerental.library.LibraryService;

public final class TestContext {

    public static final TestContext INSTANCE = new TestContext();

    private LibraryService libraryService;

    public LibraryService getLibraryService() {
        libraryService = LibraryService.getService();
        return libraryService;
    }

    public LibraryService library() {
        return libraryService;
    }

}
