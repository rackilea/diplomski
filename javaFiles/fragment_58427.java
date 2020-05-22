int num = -1;
int product = 1;
int counter = 0;
Scanner scnr = new Scanner(System.in);
System.out.println(
        "This program reads a list of integers from the user\r\n"
                + "and shows the product of the read integers");
while (num != 0) {
    System.out.print("Enter a number: ");
    num = scnr.nextInt();
    scnr.nextLine();
    if (num != 0) {
        counter++;
        product *= num;
        System.out.println(product);
    }
}

if (counter == 0)
    System.out.println("No numbers entered");
else
    System.out.println("Entered " + counter + " numbers with product: " + product);