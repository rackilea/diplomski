import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String userName = "";
        int lemonaid = 0;
        double OZ12_PRICE = 1.50;
        double OZ16_PRICE = 2.00;
        char cookies = 0;
        double COOKIES_OAT = .75;
        double COOKIES_CHOCO = .75;
        char tshirt = 0;
        double TSHIRT_Y = 15.00;
        double TSHIRT_N = 8.00;
        char item;
        char answer = 0;

        int numLemonaid = 0;
        int totalOz = 0;
        int numCookies = 0;
        int numTShirts = 0;

        System.out.println("Hello. May I ask your name?");
        userName = input.nextLine();

        System.out.println("Welcome " + userName + ". Would you like to purchase something? (Y/N) ");
        answer = input.nextLine().charAt(0);
        answer = Character.toUpperCase(answer);

        while (answer != 'N') {
            System.out.println(" ***Lemonaid Stand Program***");
            System.out.println("=======================================");
            System.out.println("Enter purchase item, first letter only.");
            System.out.println("Lemonaid, Cookies, T-shirt.");
            System.out.println("Enter Q to Quit.");
            System.out.println();
            System.out.println("Enter an item or Q to quit (L,C,T,Q)");
            item = input.nextLine().charAt(0);
            item = Character.toUpperCase(item);

            while (item != 'L' && item != 'C' && item != 'T' && item != 'Q') {
                System.out.println("Invalid input.");
                System.out.println("Please enter an item, or Q to quit. (L,C,T,Q): ");
                item = input.nextLine().charAt(0);
                item = Character.toUpperCase(item);
            }

            if (item == 'L') {
                System.out.println("What size would you like?");
                System.out.printf("%-10s%10.2f\n", "12oz.", OZ12_PRICE);
                System.out.printf("%-10s%10.2f\n", "16oz.", OZ16_PRICE);
                System.out.println("Input the number only.");
                lemonaid = input.nextInt();
                input.nextLine();

                numLemonaid++;

                while (lemonaid != 12 && lemonaid != 16)

                {
                    System.out.println("I'm sorry. Please only input an 16 or 12.");
                    lemonaid = input.nextInt();
                    input.nextLine();
                }
                totalOz += lemonaid;
                if (lemonaid == 12) {
                    // Sales_Header();
                    System.out.printf("%-10s%10.2f\n", "12oz.", OZ12_PRICE);
                }

                else if (lemonaid == 16) {
                    /// Sales_Header();
                    System.out.printf("%-10s%10.2f\n", "16oz.", OZ16_PRICE);
                }

                else {
                }

            } // end If = L
            else if (item == 'C') {
                System.out.println("What type would you like?");
                System.out.printf("%-14s%10.2f\n", "Oatmeal", COOKIES_OAT);
                System.out.printf("%-10s%10.2f\n", "Chocolate Chip", COOKIES_CHOCO);
                System.out.println("Input the first letter only. (O/C)");
                cookies = input.nextLine().charAt(0);
                cookies = Character.toUpperCase(cookies);
                numCookies++;

                while (cookies != 'O' && cookies != 'C')

                {
                    System.out.println("I'm sorry. Please only input an 'O' or 'C'.");
                    cookies = input.nextLine().charAt(0);
                    cookies = Character.toUpperCase(cookies);
                }

                if (cookies == 'O') {
                    // Sales_Header();
                    System.out.printf("%-10s%10.2f\n", "Oatmeal", COOKIES_OAT);
                }

                else if (cookies == 'C') {
                    // Sales_Header();
                    System.out.printf("%-10s%10.2f\n", "Chocolate Chip", COOKIES_CHOCO);
                }

                else {
                }

            } // end else if = C

            else if (item == 'T') {
                System.out.println("Would you like that shirt autographed?");
                System.out.printf("%-10s%10.2f\n", "With autograph", TSHIRT_Y);
                System.out.printf("%-10s%11.2f\n", "W/O autograph", TSHIRT_N);
                System.out.println("Select Yes or No (Y/N)");
                tshirt = input.nextLine().charAt(0);
                tshirt = Character.toUpperCase(tshirt);

                numTShirts++ ;

                while (tshirt != 'Y' && tshirt != 'N') {
                    System.out.println("I'm sorry. Please only input an 'Y' or 'N'.");
                    tshirt = input.nextLine().charAt(0);
                    tshirt = Character.toUpperCase(tshirt);
                }
                if (tshirt == 'Y') {
                    // Sales_Header();
                    System.out.printf("%-10s%10.2f\n", "With autograph", TSHIRT_Y);
                }

                else if (tshirt == 'N') {
                    // Sales_Header();
                    System.out.printf("%-10s%10.2f\n", "W/O autograph", TSHIRT_N);
                }

                else {
                }
            } // end else if T

            else if (item == 'Q') {
                System.out.println("Main Menu.");

            }

            else {
            }

            System.out.println("Welcome " + userName + ". Would you like to purchase something? (Y/N) ");
            answer = input.nextLine().charAt(0);
            answer = Character.toUpperCase(answer);
        } // end while

        System.out.println("Lemonaid: " + numLemonaid + "(" + totalOz +"Oz)") ;
        System.out.println("Shirts: " + numTShirts) ;
        System.out.println("Cookies: " + numCookies) ;
    }
}