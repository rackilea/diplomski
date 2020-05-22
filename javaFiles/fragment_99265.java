double total = 0;
int counter = 0;
Scanner scan = new Scanner(System.in);
System.out.println("Would you like to submit a number to calculate the average? [y/n]");
String userInput = scan.nextLine();
while (userInput.toLowerCase().startsWith("y")) {
    System.out.println("Please input a number: ");
    if (scan.hasNextInt()) {
        total += scan.nextInt();
        counter++;
    }
    scan.nextLine();
    System.out.println("Would you like to submit another number to calculate the average? [y/n]");
    userInput = scan.nextLine();
}
double average = total / counter;
System.out.println("The average of those numbers is: " + average);