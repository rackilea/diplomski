package com.example.dcsohl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparator8 {

    public static class User {
        int id; float size, size2; String username, nickname;

        public User(int id, String name, String nick, float size, float size2) {
            this.id = id;
            this.username = name;
            this.nickname = nick;
            this.size = size;
            this.size2 = size2;
        }

        public float getPercentage() {
            return (size - size2);
        }

        public String toString() {
            return id + " - " + username + "-" + nickname + "-" + size + "-" + size2 + "-diff- " + getPercentage();
        }
    }

    public static void main(String...args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "User","nickname", 1.5f, 1.5f));
        users.add(new User(1, "User","nickname", 1.5f, 1.2f));
        users.add(new User(1, "User","nickname", 1.5f, 1f));
        users.add(new User(1, "User","nickname", 1.5f, 1.6f));
        users.add(new User(1, "User","nickname", 1.5f, 1.3f));

        Comparator<User> bySizeDifferent = Comparator.comparing(user -> user.getPercentage());

        users.stream().sorted(bySizeDifferent).forEach(System.out::println);
    }

}