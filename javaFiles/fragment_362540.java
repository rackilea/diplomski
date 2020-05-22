System.out.print("enter number: ");
while (!scanner.hasNextInt()) {
    scanner.nextLine();// consume incorrect values from entire line
    //or 
    //tastiera.next(); //consume only one invalid token
    System.out.print("enter number!: ");
}
// here we are sure that user passed integer
int value = scanner.nextInt();