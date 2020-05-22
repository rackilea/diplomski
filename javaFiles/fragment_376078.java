public int enterItems()
{
int type, quantity, sale,night;
double price;
.........
System.out.println("\nNow please enter how many of Deluxe Room you want to book.");
quantity = scan.nextInt();
System.out.println("\nHow many night?");
night = scan.nextInt();
items[count] = new Deluxe(quantity,sale,night);
count++;
return quantity;
}