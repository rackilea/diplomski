while (guess > randomNumber) {
     System.out.println("lower");
     guess = getGuess(console);
     guessIncreaser++;
  }
  while (guess < randomNumber) {
     System.out.println("higher");
     guess = getGuess(console);
     guessIncreaser++;
  }