int month, day, year;
List<Integer> shortMonths = Arrays.asList(1,3,5,7,8,10,12);

while((month = scan.nextInt()) < 1 || month > 13) {
    System.out.println("Please enter a valid month...");
}

while((year = scan.nextInt()) < 1900 || year > 2020) {
    System.out.println("Please enter a valid year...");
}

while(true) {
    day = scan.nextInt();
    if(day > 0 && day < 29) { //Must be valid (1-28)
        break;
    } else if(year%4 == 0 && day == 29) { // Could be a leap year making the 29th within common range of all months.
        break;
    } //Only the 29th or 30th could get this far and be valid on a short month
      else if (shortMonths.contains(month) && (day == 30 || day == 29)) { 
        break;
    } else if (day > 0 || day < 32) { //Is it in range on any other month and year?
        break;
    } else { //Nope
        System.out.println("Please enter a valid day.");
    }
}