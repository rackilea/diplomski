import java.util.Scanner;

public class VersatileSnitSoft {
    public static void main (String [] args) { 
        double amount;
        Scanner myScanner = new Scanner(System.in);
        System.out.print ("What is the price of CD-ROM? ");
        amount = myScanner.nextDouble ();
        amount = amount + 25.00;

        System.out.print("We will bill R ");
        System.out.print(amount);
        System.out.println(" to your credit card.");
    }
}