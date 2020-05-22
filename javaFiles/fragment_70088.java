import java.util.Scanner;

public class Main {

public static void main(String[] args) {

    int length = 0;
    int width = 0;

    Scanner input = new Scanner(System.in);


    while (length <= 20 || width <= 20) {
        System.out.print("Enter the length: ");
        length = input.nextInt();
        System.out.print("Enter the Width: ");
        width = input.nextInt();

        for (int w = 0; w < length; w++) {
            for (int l = 0; l < width; l++) {
                System.out.print(" *");
            }
            System.out.println("");
        }
    }
}
}