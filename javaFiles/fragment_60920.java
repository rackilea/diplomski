import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> number = new ArrayList<>();
        String endToken = "s"; // this will be the holder of your end token
        while (true) { // iterate while user doesn't input the end token
            try {
                System.out.println("Enter an integer or enter 's' to exit!"); // ask the user for input
                String userInput = input.nextLine(); // get the user input
                if (userInput.equals(endToken)) { // check if user input is end token
                    break; // exit the loop
                }
                int a = Integer.parseInt(userInput); // convert the input into an int
                number.add(a); // add the input to the list
             // if an error inputs a String but not the end token then an exception will occur
            } catch (Exception e) {
                System.out.println("Invalid Input!"); // tell the user that the input is invalid and ask the input again
            }
        }

        input.close(); // don't forget to close the scanner

        // loop below is just used to print the user inputs
        System.out.println("Your inputs are: ");
        for (int i = 0; i < number.size(); i++) {
            System.out.println(i);
        }
    }

}