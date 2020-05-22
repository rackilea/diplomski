import java.util.Scanner;
import java.util.Random;

public class MathTutor {
    private static Random obj = new Random();

    public static int[] randomNumbers(){
        int arr[] = new int[2];   //init array to hold 2 numbers

        int x = obj.nextInt(99);
        int y = obj.nextInt(99);

        arr[0] = Math.max(x,y);
        arr[1] = Math.min(x, y);

        return arr;
    }

    public static void menu(){
        System.out.println("1. Addition Problem");
        System.out.println("2. Subtraction Problem");
        System.out.println("3. Multiplication Problem");
        System.out.println("4. Division Problem");
        System.out.println("5. Exit Program");
        System.out.print("Welcome! Please make a selection: ");
    }

    public static void main(String[] args) {

        int choice, answer;
        int[] number;
        Scanner input = new Scanner(System.in);

        do {
            menu();

            //get user's choice
            choice = input.nextInt();
            input.nextLine(); //ignore the rest of the line

            switch (choice)
            {
            case 1:
                number = randomNumbers();
                do {
                    System.out.print("What's " +number[0]+ " plus " +number[1]+ "?\n");
                    answer = input.nextInt();
                    input.nextLine();
                    if (answer != (number[0]+number[1]))
                        System.out.println("No! Please try again.");
                } while (answer != (number[0]+number[1]));

                System.out.println("\nCorrect!");           
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.err.println("*** invalid selection ***");
                break;
            }
        } while (choice != 5);
        input.close();
        System.out.println("bye.");
    }
}