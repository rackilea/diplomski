System.out.print("Enter a value as a number of pennies: ");
int pennies = inputReader.nextInt();
System.out.println(pennies + " pennies is equal to:");
int twenties = pennies / 2000;
pennies -= twenties * 2000;
int tens = pennies / 1000;
pennies -= tens * 1000;
int fives = pennies / 500;
pennies -= fives * 500;
int dollars = pennies / 100;
pennies -= dollars * 100;
int quarters = pennies / 25;
pennies -= quarters * 25;
int dimes = pennies / 10;
pennies -= dimes * 10;
int nickels = pennies / 5;
pennies -= nickels * 5;
System.out.printf("%d twenties, %d tens, %d fives, %d dollars, "
        + "%d quarters, %d dimes, %d nickels, %d pennies%n", twenties,
        tens, fives, dollars, quarters, dimes, nickels, pennies);