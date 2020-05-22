private static void inData() {
  Scanner userInputScanner = new Scanner(System.in);
  Random random = new Random();

  // Declare the stop/continue condition
  boolean isLoopContinue;

  do {
    // Generate a random number
    int expectedNumber = random.nextInt(10);

    // Ask the user to guess a number
    System.out.println("Input a number from 0-10");
    int givenNumber = userInputScanner.nextInt();

    if (givenNumber == expectedNumber) {

      // Correct answer, check if the user wants to continue
      System.out.println("You guessed the correct number!");
      System.out.println("\nInput 1 if you want to try again: ");

      // If they input "1", then we continue. Else we stop
      isLoopContinue = userInputScanner.nextInt() == 1;
    } else {

      // Wrong answer, loop again
      System.out.println("You guessed the wrong number");
      System.out.println("The correct number was: " + expectedNumber);
      isLoopContinue = true;
    }

  } while (isLoopContinue);
}