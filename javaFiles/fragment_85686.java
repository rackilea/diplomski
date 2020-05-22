System.out.println(pennies + " pennies is equal to:");
int twenties = pennies / 2000;
int tens = pennies / 1000;
int fives = pennies / 500;
int dollars = pennies / 100;
int quarters = pennies / 25;
int dimes = pennies / 10;
int nickels = pennies / 5;
System.out.printf("%d twenties, %d tens, %d fives, %d dollars, "
        + "%d quarters, %d dimes, %d nickels, %d pennies%n", twenties,
        tens, fives, dollars, quarters, dimes, nickels, pennies);