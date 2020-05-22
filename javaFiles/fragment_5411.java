System.out.println("\nEnter the date (dd/mm/yy): ");
while (true) {
    date = keys.nextLine();
    if (isValidDate(date)) {
         break;
    } else {
         System.out.println("That is not a valid date! Please enter again (dd/mm/yy): ");
    }
} 
System.out.print(date);