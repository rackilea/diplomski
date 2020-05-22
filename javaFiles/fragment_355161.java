public static void main(String[] args)
{
    // Setup some initial variables
    int bank = 10;
    double flip = Math.random();

    // Instantiate a new Scanner object
    Scanner input = new Scanner(System.in);

    // Let the user bet until they run out of money in the bank
    do
    {
        // Ask the user how much money to wager
        System.out.println("How much do you want to bet?");
        int bet = input.nextInt();

        // The bet was invalid
        while(bet < 0 || bet > bank)
        {
            System.out.println("Invalid bet (" + bet + "). Minimum bet = 0. Maximum bet = " + bank);
            bet = input.nextInt();
        }

        // Ask the user for which side
        System.out.println("Heads or tails?");
        String guess = input.next();

        // The coin is either heads or tails, so it can always start as tails. If the value goes under .5, change it to heads. If not, it remains the same, "tails".
        String coin = "tails";
        if (flip < 0.5) 
        {
            coin = "heads";
        }

        // Tell the user the result, regardless of win or lose
        System.out.println("The flip was " + coin);

        // Update the user's bank and inform them of the new value
        if(guess.equalsIgnoreCase(coin)) // this allows for any form of HeaDs or TaILs
        {
            bank += bet;
            System.out.println("You win " + bet);
            System.out.println("Your bank contains " + bank);
        }
        else
        {
            bank -= bet;
            System.out.println("You lose " + bet);
            System.out.println("Your bank contains " + bank);
        }
    }
    while(bank > 0);

    // Goodbye message
    System.out.println("Thanks for playing!");

    // Don't forget to close your Scanner object!
    input.close();  
}