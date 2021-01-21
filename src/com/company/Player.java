package com.company;

public class Player {
    private String playerName;
    private Orb choice;

    public Player(String playerName, Orb choice) {
        this.playerName = playerName;
        this.choice = choice;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Orb getChoice() {
        return choice;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setChoice(Orb choice) {
        this.choice = choice;
    }
}