// See if a lower case letter was entered
// Convert it to uppercase
if (guessed >= 97 && guessed <= 122) guessed -= 32;

// Subtract 65 to get array index
guessed -= 65;

// Make sure the guess is a letter
if (guessed <= 0 && guessed <= 25) {
    if (lettersGuessed[guessed]) {
        // The user already guessed this letter, do nothing
    } else {
        lettersGuessed[guessed] = true;
        // See if the letter guessed was right, if it was show the letters
        // If it wasn't, incorrectGuesses+1
}