package com.company.utils;

import java.util.List;

public class Cycle<T> {
    final List<T> iterable;
    int lastI;
    public Cycle(List<T> iterable) {
        this(iterable, 0);
    }
    public Cycle(List<T> iterable, int start) {
        if (iterable.size() == 0)
            throw new IllegalArgumentException("The list should've at least one element");
        this.iterable = iterable;
        lastI = start - 1;
    }
    public T next() {
        this.lastI = (this.lastI + 1) % this.iterable.size();
        return this.iterable.get(this.lastI);
    }
}
