public static void main(String[] args) {

    GuessTheNumberGame game = new GuessTheNumberGame(100);
    int turns = 0;

    Scanner kb = new Scanner(System.in);

    // TODO 4: loop as long as the guess is not correct
    while (true) {
        System.out.println("Guess a nummber between 0 and 100");
        int guess = kb.nextInt();
        if (game.isGuessHigher(guess)) {
            System.out.println("You guessed too high!");
        } else if (!game.isGuessCorrect(guess)) {
            System.out.println("You guessed too low!");
        }
        turns++;
        if (game.isGuessCorrect(guess)) break;
    }

    // TODO 5: in the loop, check guesses and give hints

    System.out.printf("You guessed the number in %d turns\n", turns);
}