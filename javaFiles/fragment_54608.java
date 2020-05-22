package com.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyClass {

    public static void main(String... args) throws IOException {
        new MyClass().readLevel(1);
    }

    private void readLevel(int i) throws IOException {
        try (InputStream is = getClass().getClassLoader()
                .getResourceAsStream("com/game/level_" + i + ".txt");
                BufferedReader br = 
                new BufferedReader(new InputStreamReader(is))) {
            String line;
            while(null != (line = br.readLine())) {
                System.out.println(line);
            }
        }
    } 
}