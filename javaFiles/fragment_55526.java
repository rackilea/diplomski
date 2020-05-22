System.out.println("Enter an int (0) to quit");
//While the user has not entered a valid int
while (!input.hasNextInt()) {
    System.out.println("Please enter an integer: ");
    //Consume the bad input
    input.nextLine();
}