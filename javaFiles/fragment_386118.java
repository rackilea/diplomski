import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Prime {

    public static List<Integer> numbers = new ArrayList<>(); // a list of integers that was accepted, can be acced in the order they were added

    private static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        int inputs = 4; // inputs wanted
        input(inputs); // gives the method the inputs wanted
        for(int i = 0; i < inputs; i++){ // for every entry in the list (notice that we add to the list in the input()
            for(int j = 0+i; j < inputs; j++) // again for every element (to sum all numbers), notice +i to prevent duplicates
            {
                if(i != j) // if the numbers aren't the same entry
                    // print the number returned from the sum function
                    System.out.println("sum of " + numbers.get(i)+ " and " + numbers.get(j) + ": " + sumPair(numbers.get(i), numbers.get(j)));
            }
        }
    }

    public static void input(int inputNumbers) {

        while(numbers.size() < inputNumbers){ // while there is more inputs needed
            System.out.print("Enter a positive integer: ");
            int num = input.nextInt();
            if(num > 0) // if the input is valid
                numbers.add(num);
            else // if the input is not valid
                while (num <= 0) { // while the input is not valid
                    System.out.print("Enter a positive integer: ");
                    num = input.nextInt(); // get the next int if it wasn't valid
                    if(num > 0) { // if the input gets valid
                        numbers.add(num);
                    }
                }
            System.out.println("Thank you.");
        }
    }

    public static int sumPair(int num1, int num2) { // sums 2 integers given to the method and returns the sum
        return num1 + num2;
    }
}