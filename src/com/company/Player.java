package com.company;

public class Player {
    private String playerName;
    private char choice;

    public Player(String playerName, char choice) {
        this.playerName = playerName;
        this.choice = choice;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getChoice() {
        return choice;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setChoice(char choice) {
        this.choice = choice;
    }
}