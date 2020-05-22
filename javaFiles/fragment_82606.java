if (userGuess.equalsIgnoreCase("higher") && nextCard > firstCard)
{
    String userGuess = JOptionPane.showInputDialog(null, "Correct! The current card is a " 
           + nextCard + ". Will the next card be higher, lower or equal?");
    correctGuesses++;
}

else if (userGuess.equalsIgnoreCase("higher") && nextCard == firstCard)
{
    String userGuess = JOptionPane.showInputDialog(null, "Correct! The current card is a " 
               + nextCard + ". Will the next card be higher, lower or equal?");
    correctGuesses++;
}

else if (userGuess.equalsIgnoreCase("lower") && nextCard < firstCard)
{
    String userGuess = JOptionPane.showInputDialog(null, "Correct! The current card is a " 
               + nextCard + ". Will the next card be higher, lower or equal?");
    correctGuesses++;
}