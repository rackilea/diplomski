import java.util.*;

 public class Purchase {
    //Properties of Purchase class - static
    private static double taxRate = 0.075; // Shared by all instances

    // Members that are instance-visible
    private int invoiceNumber;
    private double salesAmount;
    private double salesTax;

    //setter for invoiceNumber, not static as it works on a non-static field
    public void setInvoiceNum(int invNo){
        invoiceNumber = invNo;
    }

    //setter for salesAmount, not static as it works on non-static fields
    public void setSalesAmount(double salesAmnt){
        salesAmount = salesAmnt;
        salesTax = Purchase.taxRate*salesAmnt; // Note the Purchase.taxRate notation
    }

    //public static method to display purchase info
    // I keep it static just as an example : here you HAVE to give the purchase to
    // display BECAUSE the method is static
    public static void displaySalesInfo(Purchase pur){
        System.out.println("Invoice Number: " + pur.invoiceNumber);
        System.out.println("Sales Amount: " + pur.salesAmount);
        System.out.println("Sales Tax: " + pur.salesTax);
    } 

    //main method that makes use of the static properties and display method    
    public static void main (String[] args) {
        //ask user to input purchase details
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your invoice Number:" );
        int inv = scan.nextInt();

        System.out.println("Enter your Sales Amount:");
        double sales = scan.nextDouble();

        // send the user submitted purchase details to the setter methods and call display method
        Purchase myPurchase = new Purchase();
        myPurchase.setInvoiceNum(inv);
        myPurchase.setSalesAmount(sales);
        displaySalesInfo(myPurchase);     
    }

}