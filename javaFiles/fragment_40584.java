import java.util.Scanner;

public class GameReservationSystem {
    public static Scanner input = new Scanner(System.in);
    static String[] timeSlots = {"1-2pm", "2-3pm", "3-4pm", "4-5pm"};
    static String[] Games = {"Backganmon", "Chess", "Dominoes"};
    static boolean availableTime[][] = new boolean[Games.length][timeSlots.length];
    static int userChoice;

    public static void main(String[] args) {
        for (int i = 0; i < Games.length; i++) {
            for (int j = 0; j < timeSlots.length; j++) {
                availableTime[i][j] = true;
            }
        }

        mainMenu();

    }

    public static void mainMenu() {

        while (true) {
            characterPrint('-');
            for (int i = 0; i < Games.length; i++) {
                System.out.print(i + ". ");
                System.out.println(Games[i]);
            }
            characterPrint('-');
            System.out.println("input a number to choose your game!");
            userChoice = input.nextInt();

            reserveMenu(userChoice);
        }

    }

    public static void reserveMenu(int userChoice) {
        int reserveTime = 0;
        if (userChoice >= 0 && userChoice < Games.length) {

            characterPrint('-');
            System.out.println("This are the avaliable times to play" + Games[userChoice]); 
            for (int i = 0; i < timeSlots.length; i++) {
                if (availableTime[userChoice][i]) {
                    //if false, this time is not available and should not be displayed.
                    System.out.print(i + ". ");
                    System.out.println(timeSlots[i]);
                }
            }
            characterPrint('-');
            System.out.println("Input a number to reserve a time: ");
            reserveTime = input.nextInt();

        }else {
            //handle unexpected game number.
            System.out.println("Invalid game number, please try again."); 
        }

        if (reserveTime >= 0 && reserveTime < timeSlots.length) {
            //what if someone typed 0 although 0 wasn't displayed? (0 wasn't displayed, for example, because it has been reserved by someone else.)
            //So you should check whether it is available by the following line.
            if (availableTime[userChoice][reserveTime]) {
                //if true, this time hasn't been reserved, so it is a valid input.
                availableTime[userChoice][reserveTime] = false;
                System.out.println("You have succesfully reserve a time to play " + Games[userChoice] + " at" + timeSlots[reserveTime]);
            }else {
                //if already false, this time has already been reserved by someone else,
                //thus it is an invalid input.
                System.out.println("This time has already been reserved, please try again.");
            }
        }else {
            System.out.println("Invalid time number, please try again."); 
        }

    }

    public static void characterPrint(char c) {
        for (int i = 0; i < 30; i++) {
            System.out.print(c);
        }
        System.out.println();
    }
}