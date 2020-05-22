import java.util.Scanner;

class ComputeLoan

{
public static void main(String[] args) 
{
    Scanner input = new Scanner(System.in);

    //Enter number of years
    System.out.print("Enter number of years as an integer: ");
        int numberOfYears = input.nextInt();

    //Enter loan amount
    System.out.print("Enter Loan amount: ");
    double loanAmount = input.nextDouble();


    for (double intRate=5.000; intRate <8.000; intRate = intRate + .125)
    {

    //Obtain monthly interest rate
    double monthlyInterestRate = intRate / 1200;

    //Calculate payment

    double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 /                                                              Math.pow(1 + monthlyInterestRate, numberOfYears * 12));

double totalPayment = monthlyPayment * numberOfYears * 12;
    System.out.println("The InterestRate is " + intRate);
    System.out.println("The monthly payment is $" +
        (int)(monthlyPayment * 100) / 100.0);
    System.out.println("The total payment is $" +
        (int)(totalPayment * 100) / 100.0);


} 
}
}