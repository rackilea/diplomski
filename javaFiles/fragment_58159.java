while (gradeCounter <= 3) // loop 3 times
{
    System.out.print("Enter the name for customer 1: "); // prompt
    customer = input.next(); // input next name
    System.out.print("Enter the number of bottles for customer 1: "); // prompt
    bottles = input.nextInt(); // input next bottles sold
    gradeCounter = gradeCounter + 1; // increment counter by 1
// calculate purchase based on number of bottles sold
    if (bottles <= 6) {
        discount = (basePrice * bottles); // calculates discount
    } else if (bottles > 6 || bottles <= 12) {
        discount = discount * 0.05 * bottles * basePrice; // calculates discount
    } else if (bottles > 48)
    System.out.println("It is forbidden to sell above the maximum range");
    System.out.printf("\nThe Price for Customer - %s is : $%.2f\n",customer, discount);
} // end while loop