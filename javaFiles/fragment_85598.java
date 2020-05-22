public MyNumberGuess(int inGuess)
{
   Random generator = new Random(); 
   numGuesses = 1;
   prevGuess = inGuess;
   theNumber = generator.nextInt(MAX_GUESS);
}