import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String str;

        System.out.print("Do you want to start? (y/n) ");
        str = console.next();
        System.out.println();

        int num, result;
        while (str.charAt(0) == 'y') {
            System.out.print("Enter an integer (1 - 10): ");
            num = console.nextInt();

            while (num < 1 || num > 10) {
                System.out.println("NUMBER OUT OF RANGE!");
                System.out.print("Enter an integer (1 - 10): ");
                num = console.nextInt();
            }

            int i = 2;
            result = 1;
            while (i <= num) {
                result = result * i;
                i++;
            }

            System.out.println(num + "! = " + result);
            System.out.println();

            System.out.print("Do you want to continue? ");
            str = console.next();

            System.out.println();
        }
    }
}