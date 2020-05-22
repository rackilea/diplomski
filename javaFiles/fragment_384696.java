import java.util.*;

public class InputHere {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        int counter = 0;
        int average;
        int total = 0;

        System.out.println("Enter 2 Numbers");

        while (counter < 2) {
            num = scan.nextInt();
            if (counter == 1)
                System.out.println(num);
            total = total + num;
            counter++;
        }
        average = total / 2;
        System.out.println("The average is " + average);
    }

}