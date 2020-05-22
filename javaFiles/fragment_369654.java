import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {

        double number;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a value=  ");
        number = input.nextInt();

        double result = 0;
        double expectedValue = number;

        int k = 0;
        while (result < expectedValue) {
            k++;
            result = sum(k);
        }

        System.out.println(k
                + " is the  term that should be added in order to reach "
                + number + " (" + sum(k) + ")");

    }

    public static double sum(double k) {
        if (k == 1)
            return 1 / 3;
        else
            return ((k / (2 * k + 1)) + sum(k - 1));
    }
}