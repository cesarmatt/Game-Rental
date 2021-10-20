package com.example.gamerental.library;

import com.example.gamerental.model.Game;
import com.example.gamerental.utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameSearchStepDefinition {

    private Game game;
    private LibraryService libraryService = TestContext.INSTANCE.getLibraryService();

    @Given("That my library is initialized")
    public void thatMyLibraryIsInitialized() {
        libraryService = TestContext.INSTANCE.getLibraryService();
    }

    @And("the total of loaded games are {int}")
    public void theTotalOfLoadedGamesAre(int allGames) {
        assertThat(libraryService.getAllGames().size(), is(equalTo(allGames)));
    }

    @Given("I search for the game {string}")
    public void iSearchForTheGame(String gameTitle) {
        game = libraryService.searchGameByTitle(gameTitle);
    }

    @Then("I find this game")
    public void iFindThisGame() {
        Assert.assertNotNull(game);
    }

    @Then("The game was not found")
    public void theGameWasNotFound() {
        Assert.assertNull(game);
    }
}
