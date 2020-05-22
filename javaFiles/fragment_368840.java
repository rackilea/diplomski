package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static Random random = new Random();
    private ArrayList<ArrayList<String>> information = new ArrayList<>();


    private void run() {
        for (int i=0; i<10; i++) {
            ArrayList<String> informationInIteration = new ArrayList<>();
            informationInIteration.add(String.valueOf(i));
            solve(informationInIteration); // add two random number generated in function solve()
            information.add(informationInIteration);
        }
        printInformation();
    }

    private void solve(ArrayList<String> iterationInformation) {
        iterationInformation.add(String.valueOf(random.nextInt()));
        iterationInformation.add(String.valueOf(random.nextInt()));
    }

    private void printInformation() {
        for (ArrayList<String> newLine : information) {
            System.out.println();
            newLine.forEach(data -> System.out.println(data + " "));
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}