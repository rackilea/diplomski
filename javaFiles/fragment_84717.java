import java.util.Scanner;

public class Depot {
    public static void main(String[] arguments){

        // you need to initialize these to some value or else there is
        // nothing to compare them with. I tried some dummy values and
        // your code worked as expected, as long as the user entered the
        // correct values in the prompt.
        String bossName;
        String bossPassword;
        String workerName;
        String workerPassword;

        // you can just use one Scanner for the whole program, since they are
        // both just reading input from the standard input stream. Replace the
        // other Scanners with "input" and close "input" at the end
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        // not needed
        Scanner authenticate = new Scanner(System.in);
        String userName = authenticate.nextLine();
        System.out.println("Your username is " + userName);

        System.out.println("Enter your password: ");
        String passWord = authenticate.nextLine();
        System.out.println("Your password is " + passWord);

        if (userName.equals(bossName) && passWord.equals(bossPassword)) {

            // this could be declared at the top of the program instead of
            // redeclaring in the if...else
            int selection;

            Scanner bossMenu = new Scanner(System.in);
            System.out.println("1. Setup Worker Schedule");
            System.out.println("2. View Worker Schedule");
            System.out.println("3. Move Worker");
            System.out.println("4. Quit");

            do {
                selection = bossMenu.nextInt();

                if (selection == 1) {
                    System.out.println("1");
                }
                else if (selection == 2) {
                    System.out.println("2");
                }
                else if (selection == 3) {
                    System.out.println("3");
                }
                else {
                    System.out.println("4");
                }  
            } while(selection != 4); // this is usually here
                bossMenu.close();
        }
        else if (userName.equals(workerName) && passWord.equals(workerPassword)) {

            // this could be declared at the top of the program instead of
            // redeclaring in the if...else
            int selection;

            // don't need this one, just use "input" Scanner
            Scanner userMenu = new Scanner(System.in);
            System.out.println("1. View Worker Schedule");
            System.out.println("2. Quit");

            do {
                selection = userMenu.nextInt();

                if (selection == 1) {
                    System.out.println("1");
                }
            } while(selection != 2); // this is usually here

            // you would close the "input" Scanner here
            userMenu.close();
        }
    }
}