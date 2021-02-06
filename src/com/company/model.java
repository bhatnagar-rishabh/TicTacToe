package com.company;

class Orb {
    private String iVal;

    Orb(String s) {
        iVal = s;
    }

    void set(String s) {
        iVal = s;
    }

    public String toString() {
        return iVal;
    }

    static Orb both() {
        return new Orb("*");
    }

    static Orb none() {
        return Orb.none("-");
    }

    static Orb none(String i) {
        return new Orb(i);
    }
}

class StopTheGameException extends Exception {
}