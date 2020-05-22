int change = (int)(Math.ceil(changeDue*100));
    int dollars = Math.round((int)change/100);
    change=change%100;
    int quarters = Math.round((int)change/25);
    change=change%25;
    int dimes = Math.round((int)change/10);
    change=change%10;
    int nickels = Math.round((int)change/5);
    change=change%5;
    int pennies = Math.round((int)change/1);

    System.out.println("Dollars: " + dollars);
    System.out.println("Quarters: " + quarters);
    System.out.println("Dimes: " + dimes);
    System.out.println("Nickels: " + nickels);
    System.out.println("Pennies: " + pennies);