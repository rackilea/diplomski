import java.util.Scanner;

public class MakingChange {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Reading from System.in
        System.out.print("How much money do you have: ");

        double amountInDollars = 0;
        String amountInString = input.nextLine();
        boolean isValidNum = false;

        if (amountInString.equals("") || amountInString.equals(" ")) { // Empty string check
            System.out.println("Empty String");
        } else if (amountInString.matches("-?\\d+(\\.\\d+)?")) { // valid double check
            amountInDollars = Double.parseDouble(amountInString);
            isValidNum = true;
        } else {
            System.out.println("Number Format error");
        }

        if (isValidNum) {
            int amountInPennies = (int) Math.round(amountInDollars * 100);
            amountInPennies = (int) (Math.round(amountInPennies / 5.0) * 5);

            // toonies
            int numberofToonies = (int) (amountInPennies / 200.00);
            amountInPennies = amountInPennies % 200;
            // loonies
            int numberofLoonies = (int) (amountInPennies / 100.00);
            amountInPennies = amountInPennies % 100;
            // quarters
            int numberofQuarters = (int) (amountInPennies / 25.00);
            amountInPennies = amountInPennies % 25;
            // dimes
            int numberofDimes = (int) (amountInPennies / 10.00);
            amountInPennies = amountInPennies % 10;
            // nickels
            int numberofNickels = (int) (amountInPennies / 5.00);

            System.out.println("toonies:" + numberofToonies + ";" + " loonies:"
                    + numberofLoonies + ";" + " quarters:" + numberofQuarters
                    + ";" + " dimes:" + numberofDimes + ";" + " nickels:"
                    + numberofNickels);
        }

    }
}