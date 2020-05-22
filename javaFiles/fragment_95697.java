int guess = getGuess(), pass = getPassword();
if (guess == pass) {
    System.out.println("PASSWORD_ACCEPTED LOGGING_IN...");
} else {
    getDigitsOf(pass, guess);
}