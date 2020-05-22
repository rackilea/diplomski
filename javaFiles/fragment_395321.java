package sand1;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        double total = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("As you enter numbers, they will be added.");
        System.out.println("Entering a non-number will stop the program.");

        while (in.hasNextDouble()) {
            double n = in.nextDouble();
            total = total + n;
            System.out.println("The total is " + total);
        }
    }
}