import java.util.Scanner;

class Example {

    // Keep scanner reference here
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor
     */
    public Example() {
        runnerScore();
    }

    /**
     * Main method
     * 
     * @param param
     */
    public static void main(String[] param) {
        new Example();
    }

    /**
     * A method
     */
    public void runnerScore() {

        int score = 1;
        int sumOfInputs = 0;

        // for loop for the questions
        for (int i = 0; i <= 3; i++) {

            int input = input(score); // You need to save somewhere the input
                                        // you get from the user....
            System.out.println("The (" + i + ") time , input from  user was " + input);

            sumOfInputs += input; // sum every input you get

            ++score; // which is like using score = score + 1 or score+=1
        }

        // boolean expression and have used if-else statement
        if (sumOfInputs <= 32) {

            // prints out what the score is and if it is legal
            System.out.println("\nThe team has " + sumOfInputs + " points so is legal");

        } else if (sumOfInputs > 32) {

            // prints out if the score is not legal
            System.out.println("\nThe team has " + sumOfInputs + " points so is NOT legal");

        }
    }

    /**
     * Return the input from the user
     * 
     * @param score
     * @return
     */
    public int input(int score) {
        int scannerInput = 0;

        System.out.println("\nWhat is the disability class of runner " + score + "?");

        // String -> integer
        scannerInput = Integer.parseInt(scanner.nextLine());

        // Return it
        return scannerInput;

    }
}