public static void main(String[] args) {
    // Creating a play again variable
    String playAgain = "";
    // Create Scanner object
    Scanner scan = new Scanner(System.in);
    // Create a random number for the user to guess
    int theNumber = 0;
    int guessNumber = 0;
    do
    {
    // new lines to be added
    theNumber = (int)(Math.random() * 100 + 1);
    guessNumber = 0;
        System.out.println("Guess a number between 1 - 100: ");
        while (guessNumber != theNumber) 
        {
            guessNumber = scan.nextInt();
            if (guessNumber > theNumber)
            {
                System.out.println("Sorry, try again too high!");
            }
            else if (guessNumber < theNumber)
            {
                System.out.println("Sorry, try again too low!");
            }
            else
            {
                System.out.println("Congrats, you got it!");
            }
        }
        System.out.println("Would you like to play again (y/n)?");
        playAgain = scan.next();
    } while (playAgain.equalsIgnoreCase("y"));
    System.out.println("Thank you for playing! Goodbye.");
    scan.close();
}