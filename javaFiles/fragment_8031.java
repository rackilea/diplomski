public static String computersTurn() {

    // declare them here
    double randomNum = Math.random();
    String compFinalChoice = "";

    if (randomNum < 0.34) {
        compFinalChoice = "rock";
    }
    else if(randomNum <= 0.67) {
        compFinalChoice = "paper";
    } 
    else {
        compFinalChoice = "scissors";
    }

    System.out.println("The computer chooses " + compFinalChoice);
    return compFinalChoice;
}