int randomNum = new Random().nextInt(11); //Define random number between 0 (inclusive) and 10 (inclusive)
    int guess = -1;
    int numGuesses = 0;

    out.println(randomNum); //Cheater

    while (guess != randomNum) {
        guess = Integer.parseInt(JOptionPane.showInputDialog("Guess a number from 0-10: "));
        numGuesses++; //To increase the value of numGuesses by 1 each time the while loop iterates
     }

    JOptionPane.showMessageDialog(null, "You got it right after only " + numGuesses + " tries!");
    out.println(numGuesses); //To see if it matches the JOptionPane value