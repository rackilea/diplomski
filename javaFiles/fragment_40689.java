while (guess != randomNumber) {
    if (guess > randomNumber) {
        System.out.println("lower");
    }
    else {
        System.out.println("higher");
    }
    guess = getGuess(console);
    guessIncreaser++;
}