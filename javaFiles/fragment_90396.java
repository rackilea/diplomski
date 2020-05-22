int monthNumber = 0;
System.out.println("Enter a month number: ");
monthNumber = console.nextInt();
while (monthNumber > monthName.length || monthNumber < 1) {
    System.out.println("Invalid number entered");
    System.out.println("Enter a month number: ");
    monthNumber = console.nextInt();
}