package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int boardSize;
    public int count = 0;
    private ArrayList<Orb> boardList = new ArrayList<>();

    public Board(int n) {
        //User Input for Board Size NxN
        this.boardSize = n;

        //Initialize Board
        init();
    }

    void init() {
        count = 0;
        this.boardList = new ArrayList<>();
        for (int i = 0; i < this.boardSize * this.boardSize; i++) {
            this.boardList.add(i, Orb.none(String.valueOf(i + 1)));
        }
    }

    void display() {
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++)
                System.out.print("| " + this.boardList.get(i * this.boardSize + j) + " ");
            System.out.println("|");
        }
    }

    void updateBoard(int pos, Orb value) {
        pos -= 1; // due to 1 based input.
        if (pos > this.boardList.size() || pos < 0)
            throw new ArrayIndexOutOfBoundsException("position should be in bounds");
        this.boardList.set(pos, value);
        this.count += 1;
    }

    Orb getCell(int pos) {
        return this.boardList.get(pos);
    }

    public boolean isWinner() throws StopTheGameException {
        if (isWinnerInRows() || isWinnerInCols() || isWinnerInDiagonal()) return true;
        if (this.count == this.boardSize * this.boardSize)
            throw new StopTheGameException();
        return false;
    }


    private boolean isListWinner(List<Orb> orbs) {
        Orb candidate = orbs.get(0);
        for (Orb orb : orbs)
            if (orb != candidate)
                return false;
        return true;
    }

    private List<Orb> getRow(int i) {
        return this.boardList.subList(i * this.boardSize, (i + 1) * this.boardSize);
    }

    private List<Orb> getCol(int col) {
        ArrayList<Orb> ret = new ArrayList<>();
        for (int i = 0; i < this.boardSize; i++) {
            ret.add(this.boardList.get(col + this.boardSize * i));
        }
        return ret;
    }

    private List<Orb> getLeftDiagonal() {
        ArrayList<Orb> ret = new ArrayList<>();
        for (int i = 0; i < this.boardSize; i++) {
            ret.add(this.boardList.get(i * this.boardSize + i));
        }
        return ret;
    }

    private List<Orb> getRightDiagonal() {
        ArrayList<Orb> ret = new ArrayList<>();
        for (int i = 0; i < this.boardSize; i++) {
            ret.add(this.boardList.get((i + 1) * (this.boardSize - 1) + 1));
        }
        return ret;
    }

    private boolean isWinnerInRows() {
        for (int i = 0; i < this.boardSize; i++) {
            if (isListWinner(getRow(i))) return true;
        }
        return false;
    }

    private boolean isWinnerInCols() {
        for (int i = 0; i < this.boardSize; i++) {
            if (isListWinner(getCol(i))) return true;
        }
        return false;
    }

    private boolean isWinnerInDiagonal() {
        if (isListWinner(getLeftDiagonal())) return true;
        return isListWinner(getRightDiagonal());
    }
}