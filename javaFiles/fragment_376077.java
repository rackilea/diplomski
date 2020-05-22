DecimalFormat fmt = new DecimalFormat("0.##");
Hotel run = new Hotel();
int quantity, sale,night;
Register family = new Family();
Register suite = new Suite();

Scanner input = new Scanner(System.in);
System.out.println("Enter customer's name:");
String name = input.next();

quantity = run.enterItems();
Register deluxe = new Deluxe(quantity,0,0); // entering the default value for the other two parameters like the empty constructor would leave them.
if(run.count != 0)
{
System.out.println("\nHotel Reservation Payment");
System.out.println("============================");
System.out.println("Customer name: " + name);
deluxe.displayInfo(); //supposed to print the details
family.displayInfo(); //supposed to print the details
suite.displayInfo();  //supposed to print the details
System.out.println("The final total is RM" + fmt.format(run.calcTotal()));
}
else
{
  System.out.println("No items entered.");
  run.enterItems();
}