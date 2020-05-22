public void playGame() {

    //generate randown number bewteen 1 and 100
    numberGenerator = new Random();

    // .... etc...

    // ***** this will lock your GUI!! *******
    while ((answer1 != correctAnswer) && (answer2 != correctAnswer)) {

        intro.setText("I have a number bewteen 1 and a 100."
                + "Can you guess my number?");
        // ....
    }

}//end method playGame