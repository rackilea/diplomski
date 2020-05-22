package fitnessclassapp;
import java.util.Scanner;
public class BookingController { 
    private Scanner input = new Scanner(System.in);
//  Customer customer = new Customer();

    // customer enter details and the details are validated
    private String Customer() {

        String customerName = "";
        int customerAge = -1;
        String membership = "";
        boolean isName;

        System.out.println("Please enter your name ");
        do {
            // name of condition HasNext will check the user input
            if (input.hasNext()) {
                customerName = input.nextLine();
                isName = true;

                // add a boolean
            } else
                System.out.println("You have provided incorrect information");

            isName = false;
            input.next();

        } while (!isName);

        System.out.println(customerName);

        return customerName;
    }

    public static void main(String[] args) {
        BookingController con = new BookingController();
        con.Customer();
    }

}