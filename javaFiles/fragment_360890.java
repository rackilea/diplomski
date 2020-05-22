public void checkAnswer(){      
    int answer = question.getAnswer();
    int response = ansID1;

    if(ansID2 >= 0) {
        response = 10 * response + ansID2;
    } // else a one-digit response
    if (answer == response) {
        makeEquation();
    }
}