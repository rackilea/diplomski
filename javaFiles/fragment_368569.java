import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {

        final Scanner input = new Scanner(System.in);

        System.out.println("What is the number in the decimal system that you want to convert to binary?");
        int dec = input.nextInt();
        int div = 128;

        while (div > 0) {

            System.out.print(dec / div);
            dec = dec % div;
            div >>= 1; // equivalent to div /= 2
        }
        System.out.println();
    }
}