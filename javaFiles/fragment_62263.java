System.out.println("Would you like to change one of your guesses? yes/no");
if(scan.next() == "yes") 
{
    System.out.println("What guess would you like to change? 1/2/3");
    if(scan.nextInt() == 1 || scan.nextInt() == 2 || scan.nextInt() == 3) 
    {
        int temp = scan.nextInt();
        System.out.println("What is your new guess?");
        guess[temp-1] == scan.nextInt(); // -1 because array index starts at 0
    }
    else
        System.out.println("That's not a valid guess number");
}