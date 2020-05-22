import java.util.Scanner;

public class ABC {
public static void main(String []args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Feed me with numbers!");

        while((num = scanner.nextInt()) > 0) {
            System.out.println("Keep Going!");
        }

        {
            System.out.println("Number is negative! System Shutdown!");
            System.exit(1);
        }

    }
}