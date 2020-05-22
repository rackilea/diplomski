public int CheckAnswers () {
    boolean incorrectAnswer = true;

    do {
        playerAnswer = CheckAnswers();
        if (playerAnswer < 1 || playerAnswer > 4) {
          System.out.println("You have entered an incorrect number.");
          System.out.println("Please enter a  number between 1 and 4");
        } 
        else {
           return (playerAnswer); 
        }
    } while (incorrectAnswer);
    return -1; //unreachable statement
}