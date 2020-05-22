import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {
        int rows, number = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of rows");
        rows = sc.nextInt();

        System.out.println("Enter no to start with");
        number = sc.nextInt();

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                ++number;
                if (number == 10) {
                    number = 1;
                }
            }
            System.out.println();
        }
    }
}