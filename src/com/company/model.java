package com.company;


enum Orb {
    X, O, NONE, BOTH
}

interface IGame {
    Orb isWinner();
}