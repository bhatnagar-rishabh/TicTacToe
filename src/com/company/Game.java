package com.company;

import java.util.List;

public class Game implements IGame {
    private Orb isListWinner(List<Orb> orbs) {
        Orb candidate = orbs.get(0);
        for (Orb orb : orbs)
            if (orb != candidate)
                return Orb.NONE;
        return candidate;
    }

    boolean isPlayer(Orb candidate) {
        return candidate != Orb.NONE && candidate != Orb.BOTH;
    }

    private Orb isWinnerInRows() {
        for (int i = 0; i < this.size; i++) {
            Orb candidate = isListWinner(getRow(i));
            if (candidate != Orb.NONE) {
                return candidate;
            }
        }
        return Orb.NONE;
    }

    private Orb isWinnerInCols() {
        for (int i = 0; i < this.size; i++) {
            Orb candidate = isListWinner(getCol(i));
            if (candidate != Orb.NONE) {
                return candidate;
            }
        }
        return Orb.NONE;
    }

    private Orb isWinnerInDiagonal() {
        Orb candidate;
        candidate = isListWinner(getLeftDiagonal());
        return candidate != Orb.NONE ? candidate : isListWinner(getRightDiagonal());
    }

    // returns
    //    Orb.X | Orb.O: if we have a winner.
    //    Orb.BOTH: if the match is draw.
    //    Orb.NONE: if there is still a place empty
    @Override
    public Orb isWinner() {
        int n = this.size;
        Orb candidate;
        candidate = isWinnerInRows();
        if (isPlayer(candidate)) return candidate;

        candidate = isWinnerInCols();
        if (isPlayer(candidate)) return candidate;

        candidate = isWinnerInDiagonal();

        return candidate;
    }
}
