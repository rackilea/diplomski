package com.riapriority.test;

public class WithincodeTest {
    public static void main(String[] args) {
        Banana monkeyBanana = new Banana();
        Monkey monkey = new Monkey();
        monkey.feed(monkeyBanana);
        try {
            monkey.feed(monkeyBanana);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        Banana airplaneBanana = new Banana();
        Airplane airplane = new Airplane();
        try {
            airplane.feed(airplaneBanana);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}