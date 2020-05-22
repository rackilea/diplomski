private static Scanner input;

public static void main(String[] args) 
{
    Random rand = new Random();
    int numbertoguess = rand.nextInt(10);
    int numberoftries =0;
    input = new Scanner(System.in);
    int guess;
    boolean win = false;

    while(win == false)
    {
        System.out.println("Guess a number between 1 and 10");
        try
        {
        guess = Integer.parseInt(input.next());
        numberoftries++;

        if (guess == numbertoguess)
        {       
            win = true;
            System.out.println("That is correct !!");
            System.out.println("The number is : " + numbertoguess + " and it took you " + numberoftries + " tries");

        }
        else  
        {
            throw new BadGuessException();
        }
    }
    catch(NumberFormatException e)
    {
        System.out.println("Sorry, you entered an invalid number Format!");
    }
    catch(BadGuessException ex) 
    {
        System.out.println("Sorry, you guessed the wrong number!  ");
    }
}