package com.company;

import com.company.utils.Cycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int getPositionInput(Scanner sc) {
        System.out.print("Your move: ");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PlayerManager pm = new PlayerManager(Arrays.asList(new Orb("X"), new Orb("O")), 2, sc);
        Board board = new Board(3);


        boolean isWinner = false;
        while (!isWinner) {
            Player currentPlayer = pm.getNextPlayer();
            int pos = getPositionInput(sc);
            board.updateBoard(pos, currentPlayer.getChoice());
            board.display();
            try {
                isWinner = board.isWinner();
            } catch (StopTheGameException e) {
                System.out.println("The game is draw");
                break;
            }
        }
    }
}

class PlayerManager {
    Cycle<Player> players;
    final int numberOfPlayers;
    final List<Orb> choices;
    final Scanner sc;
    int i = 0;

    PlayerManager(List<Orb> choices, int numberOfPlayers, Scanner sc) {
        this.choices = choices;
        this.numberOfPlayers = numberOfPlayers;
        this.sc = sc;

        if (this.numberOfPlayers > choices.size()) {
            throw new IllegalArgumentException("number of choices must be greater than the number of players");
        }
        this.initPlayers();
    }

    String getPlayerName() {
        System.out.print("Enter Player Name: ");
        return this.sc.next();
    }

    Player getNewPlayer(Orb choice) {
        return new Player(getPlayerName(), choice);
    }

    Player getNextPlayer() {
        return this.players.next();
    }

    void initPlayers() {
        List<Player> lp = new ArrayList<>();
        for (int i = 0; i < this.numberOfPlayers; i++) {
            lp.add(getNewPlayer(choices.get(i)));
        }
        players = new Cycle<>(lp);
    }
}