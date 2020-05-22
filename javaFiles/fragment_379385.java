public void checkTheAnswer(String userInput) {
    String display = "";
    boolean scored = false;
    for (int i = 0; i < answer.length(); i++) {
        char hide = '-';

        if (userInput.charAt(0) == answer.charAt(i)) {
            hide = userInput.charAt(0);
            scored = true;
        }

        display += hide;

    }//end for
    //increment miss only if the answer doesn't contain the letter user guessed
    if(!scored) sketchHangMan.sketchTheMan(++miss); 
    displayResult(display);

}