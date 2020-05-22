package eu.webfarmr;

import java.util.Scanner;

public class Survey {
    // Number of people
    private final static int PERSON_COUNT = 4;

    // Questions
    private final static String[] QUESTIONS = new String[] { 
        "Have you ever like shopping online? ",
        "Did you start your christmas shopping? ",
        "Are you waiting for Black Friday sales? " };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Yes or No:");

        // people Loop
        int[][] answer = new int[PERSON_COUNT][QUESTIONS.length];
        for (int personIndex = 0; personIndex < PERSON_COUNT; personIndex++) {
            System.out.println("person " + personIndex);

            // Question Loop
            for (int questionIndex = 0; questionIndex < QUESTIONS.length; questionIndex++) {
                // Answer yes or no only
                boolean valid = false;
                do {
                    System.out.print(QUESTIONS[questionIndex]);
                    String userInput = in.next();
                    valid = userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no");
                    if (!valid) {
                        System.out.println("Please enter Yes or No");
                    } else {
                        answer[personIndex][questionIndex] = userInput.equalsIgnoreCase("yes")? 1:0;
                    }
                } while (!valid);
            }
            System.out.println();
        }

        // survey results
        System.out.println("Survey Results\t\t\t\t Yes\t No");

        for (int i = 0; i < QUESTIONS.length; i++) {
            int total = 0;
            for (int j = 0; j < PERSON_COUNT; j++)
                total += answer[j][i];

            int percent = (total * 100) / PERSON_COUNT;
            System.out.println(QUESTIONS[i] + "\t " + percent + "%\t " + (100 - percent) + "%");
        }
    }
}