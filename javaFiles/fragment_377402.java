/* Promt how many books */
System.out.print("How many books? ");
int bookCount = scanner.nextInt();
scanner.nextLine(); // finish the line...
double totalPrice = 0.0d; // create a counter for the total price

/* Ask for each book the name and price */
for (int i = 0; i < bookCount; ++i)
{
    System.out.print("Name of the book? ");
    String name = scanner.nextLine();  // get the name
    System.out.print("Price of the book? ");
    double price = scanner.nextDouble(); // get the price
    scanner.nextLine(); // finish the line
    totalPrice += price; // add the price to the counter
}

/* If you bought more than 1 book, you get discount */
if (bookCount >= 2)
{
    totalPrice *= 0.8d;
}

/* Print the resulting price */
System.out.printf("Total price to pay: %.2f%n", totalPrice);