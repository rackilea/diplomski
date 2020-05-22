public static void startGame(boolean isAWinner) {
    int lives = 5;
    do {
        //TODO: run checkNumber on result of loadNumber and assign its result to isAWinner
        loadNumber();
        lives--;
    } while (lives > 0 || !isAWinner);  //TODO: has lives AND is not a winner
}