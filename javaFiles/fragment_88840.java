package com.sandbox;

import java.util.ArrayList;
import java.util.List;

public class Sandbox {

    public static void main(String[] args) {
        List<Character> rawInput = new ArrayList<Character>();
        rawInput.add(new Character("Foo", new Location(1, 2, 3)));        
    }

    public static class Character {

        private String name;

        private Location location;
        public Character(String name, Location location) {
            this.name = name;
            this.location = location;
        }
    }

    public static class Location {
        private int x;
        private int y;
        private int z;

        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}