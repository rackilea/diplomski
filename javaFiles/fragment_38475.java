while (!win) {
    System.out.println("Guess a number between 1 and 10: ");
    try {
        guess = input.nextInt();
        numberOfTries++;

        if (guess == numberToGuess) {
            win = true;
            System.out.println("YOU GOT IT!");
            System.out.println("It took you " + numberOfTries + " tires.");
        } else if (guess < 1 || guess > 10) {
            throw new BadGuessException();
        }
    } catch (InputMismatchException e) {
        input.nextLine();
    }
}