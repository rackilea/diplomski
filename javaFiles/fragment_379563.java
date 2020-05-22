import java.util.Scanner; // import Scanner object to get user input

public class ArrRandomNum {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // initialize Scanner object 'input'.
        System.out.print("Enter a number: "); // prompt.
        int n = input.nextInt(); // parse and assign the next int. use lowercase for variables.
        input.close(); // close Scanner object 'input' to avoid resource leaks.

        int[] arr = new int[n]; // initialize array 'arr' of size 'n'.

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int) (Math.random() * 100); // assign random int 0-100 (100 exclusive)

        }

        for (int j = 0; j < arr.length; j++) {

            System.out.printf("%d, ", arr[j]); // print arr[j] value and a ', '.

            if ((j+1) % 5 == 0) { // every 5 numbers goes down a line.

                System.out.println();

            }
        }
    }
}