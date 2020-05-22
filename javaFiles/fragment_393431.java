package com.example.calebseeling.french;

import java.util.Random;

public class Letter {

    private static Random randomgenerator = new Random();
    private static int randomNumber;

    public static String[] Letters = {
        "Oui",
        "Ca va"
    };
    public static String[] LettersG = {
        "Ja",
        "Wie Gehts"
    };

    public static String getLetter() {
        randomNumber = randomgenerator.nextInt(Letters.length);
        return Letters[randomNumber];
    }

    public static String getCorrespondingGermanLetter() {
        return LettersG[randomNumber];
    }
}