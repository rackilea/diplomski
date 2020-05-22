import java.text.NumberFormat;
import java.util.Scanner;

public class InvoiceApp
{
  public static void main(String[] args)
  {
    // Begin input
    Scanner sc = new Scanner(System.in);
    String customerType = null;
    boolean choice = true;
    while (choice)
    {
      // get the input from the user
      System.out.print("Enter customer type (r/c): ");
      customerType = sc.next();
      while (!customerType.equalsIgnoreCase("r")
          && !customerType.equalsIgnoreCase("c"))
      {
        System.out.println("Enter a valid customer type r or c");
        customerType = sc.next();
      }

      System.out.print("Enter subtotal:   ");

      double subtotal = sc.nextDouble();
      // get the discount percent
      double discountPercent = 0;
      if (customerType.equalsIgnoreCase("R"))
      {
        if (subtotal < 100)
          discountPercent = 0;
        else if (subtotal >= 100 && subtotal < 250)
          discountPercent = .1;
        else if (subtotal >= 250)
          discountPercent = .2;
      }
      else if (customerType.equalsIgnoreCase("C"))
      {
        if (subtotal < 250)
          discountPercent = .2;
        else
          discountPercent = .3;
      }
      else
      {
        discountPercent = .1;
      }

      // calculate the discount amount and total
      double discountAmount = subtotal * discountPercent;
      double total = subtotal - discountAmount;

      // format and display the results
      NumberFormat currency = NumberFormat.getCurrencyInstance();
      NumberFormat percent = NumberFormat.getPercentInstance();
      System.out.println("Discount percent: " + percent.format(discountPercent)
          + "\n" + "Discount amount:  " + currency.format(discountAmount) + "\n"
          + "Total:            " + currency.format(total) + "\n");

      // see if the user wants to continue
      System.out.print("Continue? (y/n): ");
      String userInput = sc.next();
      choice = userInput.equalsIgnoreCase("y");
      System.out.println();
    }
    sc.close();
  }
}