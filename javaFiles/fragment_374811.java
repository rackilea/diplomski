import java.util.Scanner;

public class ifToSwitchConversion {

public static void main(String [] args) {

    // Declare a Scanner and a choice variable
    Scanner stdin = new Scanner(System.in);
    int choice = 0;

    System.out.println("Please enter your choice (1-4): ");
    choice = stdin.nextInt();


    switch(choice) {
        case 1:
            System.out.println("You selected 1.");
            break;
        case 2:
        case 3:
            System.out.println("You selected 2 or 3.");
            break;
        case 4:
            System.out.println("You selected 4.");
            break;
        default:
            System.out.println("Please enter a choice between 1-4.");
    }

  }

}