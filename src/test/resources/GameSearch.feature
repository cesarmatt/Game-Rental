Feature: Game search on my rental catalogue

  Scenario:
    Given That my library is initialized
    And the total of loaded games are 10

  Scenario: Search a game with a given title
    Given I search for the game "Minecraft"
    Then I find this game

  Scenario: Search for a game that does not exist
    Given I search for the game "GTA"
    Then The game was not found