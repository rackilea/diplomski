package com.riapriority.test;

public class Monkey {
    @CanEat
    public void feed(Banana b) {
        b.eat();
    }
}