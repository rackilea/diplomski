System.out.print("Please enter a positive integer number: ");
if (scan.hasNextInt()) {
    num = scan.nextInt();
} else {
    System.out.println("I need an int, please try again.");
    scan.nextLine();
}