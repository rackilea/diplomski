// Create the StringBuilder starting from ------
final StringBuilder sb = new StringBuilder(dashes);

// Loop the String "Italia"
for (int i = 0; i < toBeGuessed.length(); i++) {
    final char toBeGuessedChar = toBeGuessed.charAt(i);

    // Is the character at the index "i" what we are looking for?
    // Remember to transform the character to the same form as the
    // guessed letter, maybe lowercase
    final char c = Character.toLowerCase(toBeGuessedChar);

    if (c == letter) {
        // Yes! Update the StringBuilder
        sb.setCharAt(i, toBeGuessedChar);
    }
}

// Get the final result
final String result = sb.toString();