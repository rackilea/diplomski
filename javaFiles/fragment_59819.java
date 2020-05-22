package operators;

import java.util.Scanner;

public class assignment2ifelse {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int quantity;
    int packages = 99;
    System.out.println("Enter a quantity : ");
    quantity = input.nextInt();
    double dis1 = .2; // dis2 = .33, dis3 = .42, dis4 = .29;
    double price = packages * quantity;
    double discount = 0;
    double finalprice = price * discount;

    if (quantity < 20 && quantity > 9) {
      System.out.println(price);
      discount = price * dis1;
      System.out.println(discount);
      System.out.println(finalprice);
    } else {
      System.out.println("Quantity doesn't match expectations.");
    }
  }
}