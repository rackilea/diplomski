package com.riapriority.test;

public class Banana {
    private static int bananaIdGen;
    private final int bananaId = ++bananaIdGen;
    private boolean eaten = false;

    public void eat() {
        if (eaten)
            throw new IllegalStateException("Already eaten.");
        else
            eaten = true;
    }

    public int getBananaId() {
        return bananaId;
    }
}