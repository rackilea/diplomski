public static void main(String[] args)
{
    // Create a Scanner object
    Scanner input = new Scanner(System.in);

    // Create an Extremes object
    Extremes extreme = new Extremes();

    // Ask the user to guess the maximum value of an Integer
    System.out.println("Guess the maximum Integer value: ");
    int max = input.nextInt(); // your first error, assign input to integer, 

    // Compute and display the difference
    // between the max and the guess
    System.out.print("You were off by " + extreme.maxDiff(max)); // your second error, invoke emthod by ref 

    // Ask the user to guess the minimum value of an Integer
    System.out.println("Guess the minimum Integer value: ");
    int min = input.nextInt(); // yout third error assign input to int

    // Compute and display the difference
    // between the min and the guess
    System.out.println("You were off by " + extreme.minDiff(min)); // and again invoke method correctly


}