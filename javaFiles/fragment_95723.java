import java.util.Scanner;

public class Welcome {

public static void main(String[] args) {
    int dogs;

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the number of dogs: ");
    dogs = scan.nextInt();

    switch (dogs) {
        case 0:
            System.out.println("You've earned 0 points!");
            break;
        case 1:
            System.out.println("You've earned 5 points!");
            break;
        case 2:
            System.out.println("You've earned 15 points!");
            break;
        case 3:
            System.out.println("You've earned 30 points!");
            break;
        case 4:
            System.out.println("You've earned 60 points!");
            break;

        default:
            System.out.println("You've earned 60 points!");

    }
}