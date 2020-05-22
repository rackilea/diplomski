import java.util.*;
class Scratch {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int sum = 0;
       int input;

       do {
           System.out.print("Enter a number: ");
           input = in.nextInt();
           if (input % 10 != 0)
               sum += input;

       } while (input % 10 != 0)

       System.out.println("The total value is: " + sum);
       System.out.println("The last input was divisible by 10");
    }
}