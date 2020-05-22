import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int end;
        int start;
        List<Integer> evenNumbers = new ArrayList<Integer>();

        System.out.println("Enter the starting number");
        start = keyboard.nextInt();
        System.out.println("Enter the ending number");
        end = keyboard.nextInt();

        for (int i = start; i <= end; i++) {

            if (i % 2 == 0) {
                evenNumbers.add(i);
            }
        }

        System.out.println("There are " + evenNumbers.size() + " even numbers between [" +start +"," + end + "]");
        System.out.println("The numbers are: " + evenNumbers.toString());

    }
}