List<Character> repeatedLetters = new ArrayList<>();

int incorrect = 0;
while (incorrect < 7)
{
    System.out.println("\nGuess a letter: ");
    char guess = kb.next().toUpperCase().charAt(0);  // case insensitive

    if (validateCharacter(guess) && repeatedLetters.contains(guess)) {
        System.out.println("You already guessed " + guess + ".");
        continue;
    }
    else {
        repeatedLetters.add(guess);
    }

    // Other things
}