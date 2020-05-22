while(guessResult != -1) {

    randomGuess = GameTwo.nextInt();
    guessResult = checkGuess(randomGuess);
    GameTwo.nextLine();
    System.out.println("Random Guess: " + randomGuess); //Try here

}