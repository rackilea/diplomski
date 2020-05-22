import java.io.IOException;
import java.util.Scanner;
abstract class Loan
{

};
class HomeLoan extends Loan
{
    String loan_Number;
    public HomeLoan(String nameOf, String id_Number, String loan_Number,
            double loan_Amount, double interest_rate, int term,
            double c_balance, String address) {
        // TODO Auto-generated constructor stub
        this.loan_Number=loan_Number;
    }
    public String getHomeLoanNumber()
    {
        return "THIS IS HomeLoan Object:"+loan_Number;
    }
}
class CarLoan extends Loan
{
    String loan_Number;
    public CarLoan(String name, String id_number, String loan_number,
            double loan_amount, double interest_rate, int term,
            double c_balance, String make, String model, String year) {
        this.loan_Number=loan_number;
    }
    public String getCarLoanNumber()
    {
        return "THIS IS CarLoan Object:"+loan_Number;
    }
}
public class Test {



 private static Loan getLoanInfo(Scanner scan,char c)
 {

      System.out.println("Please enter your Name: ");
        String nameOf = scan.next();

        System.out.println("Please enter an ID Number: ");
        String id_Number = scan.next();
        System.out.println("Please enter a Loan Number: ");
        String loan_Number = scan.next();
        System.out.println("Please enter the amount of the Loan: ");
        double loan_Amount = scan.nextDouble();

        System.out.println("Please enter your desired Interest Rate: ");
        double interest_rate = scan.nextDouble();
        while(interest_rate > 100.00){ //Check valid number
        System.out.println("Invalid percentage. Please enter 0.00 -    100.00");
        interest_rate = scan.nextDouble();
        }
        System.out.println("How long will you like the loan? Please enter 1-30.");
        int term = scan.nextInt();
        while(term > 30){ // Check for valid number
        System.out.println("Invalid number of years. Please enter 1-30.");
        term = scan.nextInt();
        }
        System.out.println("Current balance is being set to the Loan amount: ");
        double c_balance = loan_Amount;

        if(c=='H')
        {
             System.out.println("Please enter an address for the Home: ");
                String address = scan.next();

             return new HomeLoan(nameOf,id_Number,loan_Number,loan_Amount,
                        interest_rate,term,c_balance,address);
        }
        else if(c=='C')
        {
              System.out.println("Please enter the Make of the car: ");
                String make = scan.next();
                System.out.println("Please enter the Model of the car: ");
                String model = scan.next();
                System.out.println("Please enter the Year of the car: ");
                String year = scan.next();
                return new CarLoan(nameOf,id_Number,loan_Number,loan_Amount,interest_rate,
                        term,c_balance,make,model,year);
        }
        else
        return null;
 }
public static void main(String[] args) throws IOException {

    int HomeCount,CarCount;
    HomeLoan HL[]=null;
    CarLoan CL[];
    System.out.println("Welcome to the Loan system!  \n");
    System.out.println("What type of Loan do you want? ");
    System.out.println("Please enter 'H' for Home or 'C' for Car: ");
    Scanner scan=new Scanner(System.in);
    for(int i = 0; i < 5; i++){ 

    char c = scan.next().charAt(0);

    if(c == 'H'){

        System.out.println("\nHow many Home Loans would you like? ");
        HomeCount = scan.nextInt();
        HL= new HomeLoan[HomeCount];
        for(int j = 0; j < HomeCount; j++){

            HL[j]=(HomeLoan)getLoanInfo(scan,c);
            System.out.println(HL[j].getHomeLoanNumber());

        }

        System.out.println("Would you like to view your loan? ");
        char x = scan.next().charAt(0);

        if( x == 'Y'){
            System.out.println(HL); //When using getInfo method HL is not in scope
        }
        }

        if(c == 'C'){

        System.out.println("\nHow many Car Loans would you like? ");
        CarCount = scan.nextInt();

        CL = new CarLoan[CarCount];

        for(int j = 0; j < CarCount; j++){ //Loop through loans

            CL[j]=(CarLoan)getLoanInfo(scan,c);
            System.out.println(CL[j].getCarLoanNumber());

        }

        }
    }
}