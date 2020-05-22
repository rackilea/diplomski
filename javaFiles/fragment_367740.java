import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[100];
        int i = 0;
        while (i < 100) { // Check if the array is already full
            System.out.print("Enter 0 to Exit or enter the integers between 1 and 50 (Input #" + (i + 1) + ") : ");
            int value = input.nextInt();
            if (value == 0) {
                break;
            }
            if (value < 1 || value > 50) { // check if input is between 1 and 50
                System.out.println("Input is not between 1 and 50");
            } else {
                num[i] = value;
                System.out.println();
            }

            i++;
        }
        System.out.println();
        System.out.println("Result: ");
        for (int j = 0; j < i; j++) {
            int n = 0;
            boolean isAlreadyPrinted = false; // flag to check if will be printed or not
            for (int k = 0; k < i; k++) {
                if (num[j] == num[k]) {
                    if (j > k) { // this means that the same value is already found and printed
                        isAlreadyPrinted = true;
                    }
                    n++;
                }

            }

            if (!isAlreadyPrinted) {
                System.out.println(num[j] + " occurs " + n + " times");
            }
        }
    }

}