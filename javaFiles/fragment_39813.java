if (anotherGame.equals("no")) {
    weArePlaying = 0;
} else if (anotherGame.equals("yes")) {
    weArePlaying = 1;
    attempts = 10;
    guessedLetters.clear();
}
else {
    weArePlaying = 1;
}