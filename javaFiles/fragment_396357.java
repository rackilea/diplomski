import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WagesCalculator
{

  public static void main(String[] args)
  throws Exception
  {
    WagesCalculator wc = new WagesCalculator();
    wc.calculate();
  }

  public void calculate()
  throws FileNotFoundException
  {
    Scanner file = new Scanner(new FileReader("task3.txt"));
    Scanner sc = new Scanner(System.in);

    // Current tax variable value
    double tax = 20;

    // User Input Y or N to change tax variable value
    System.out.println("- - Hotel Tax System - -");
    System.out.print("Do you want to specify a custom Tax Rate? [Y|N]: ");

    // if statement to change tax variable value subject to Y or N
    if (sc.next().equalsIgnoreCase("Y"))
    {
      System.out.print("Please enter the new tax value: ");
      tax = new Scanner(System.in).nextInt();
    }

    // Prints out current tax value
    System.out.println("The current tax rate is " + tax + ".");

    List<Room> rooms = new ArrayList<Room>();

    while (file.hasNext())
    {
      String name = file.next();
      int numberOfBookings = file.nextInt();
      double price = file.nextDouble();
      rooms.add(new Room(tax, name, numberOfBookings, price));
    }

    file.close();

    rooms.stream().forEach(e -> System.out.println(e));
    double totalIncome = rooms.stream().map(r -> r.income)
    .reduce((a, b) -> a + b).orElse(0.0);
    double totalTax = rooms.stream().map(r -> r.tax).reduce((a, b) -> a + b)
    .orElse(0.0);
    System.out.printf("Total income was: %d\nTotal tax was %d\n", totalIncome,
    totalTax);
  }

  class Room
  {
    double tax;

    String name;

    int numberOfBookings;

    double price;

    double income;

    double paidTax;

    public Room(double tax, String name, int numberOfBookings, double price)
    {
      this.tax = tax;
      this.name = name;
      this.numberOfBookings = numberOfBookings;
      this.price = price;
      this.income = numberOfBookings * price;
      this.paidTax = income * (tax / 100);
    }

    @Override
    public String toString()
    {
      return String.format(
      "Room Type: %s, Bookings: %d, Room Price:  £%.2f, Income: £%.2f,         Tax: %.2f %n",
          name, numberOfBookings, price, income, paidTax);
    }
  }
}