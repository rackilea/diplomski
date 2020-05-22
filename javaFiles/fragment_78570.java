package com.steve.research;

public class Quiz {

    private int counter;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private String rightAnswer;

    public Quiz(int counter, String question, String answer1, String answer2, String rightAnswer) {
        this(counter, question, answer1, answer2, null, null, rightAnswer);
    }

    public Quiz(int counter, String question, String answer1, String answer2, String answer3, String rightAnswer) {
        this(counter, question, answer1, answer2, answer3, null, rightAnswer);
    }

    public Quiz(int counter, String question, String answer1, String answer2, String answer3, String answer4, String rightAnswer) {
        this.counter = counter;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.rightAnswer = rightAnswer;
    }
}