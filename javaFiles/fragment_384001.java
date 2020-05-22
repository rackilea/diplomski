public class Main {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) 
{
    System.out.println(" Welcome ");

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    int guess = 0;
    int number_of_tries = 0;

    System.out.println(" Try too guess a number between 1 and 100 -1 to close");
    guess = input.nextInt(); //get first input
    while (guess != -1)
    {
        int number_guess = rand.nextInt(5) + 1;
        ++number_of_tries;

        //check if user wins and exits loop 
        if (isWin (number_guess,guess))
        {
            System.out.println(" You Win!!! ");
            System.out.println(" The number was " + number_guess);
            System.out.println(" It took you " + number_of_tries + " tries " +
                    "\nWould you like to play again? [1 yes/ -1 no]: ");
            guess = input.nextInt();
            if (guess == -1)
            break;

            else
                System.out.println(" Try too guess a number between 1 and 100 -1 to close");
        }
        else if (number_guess < guess )
        {
            System.out.println(" Guess is too High " + "\n Guess another number to continue or -1 to quit ");
            guess = input.nextInt();
            continue;
        }
        else if (number_guess > guess)
        {
            System.out.println(" Guess is too low " + "\n Guess another number to continue or -1 to quit ");
            guess = input.nextInt();
            continue;
        }

    }
    System.out.println ("bye bye");
}

public static boolean isWin (int number,int guess)
{
    return (number == guess) ? true :false;
}