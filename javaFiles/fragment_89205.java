Scanner heightscanner = new Scanner(System.in);
System.out.println("Define your height in centimetres.");

while(!heightScanner.hasNextDouble()) {
    System.out.println("Invalid Input. Define your height in centimetres.");
    heightScanner.nextLine();
}
height = heightscanner.nextDouble();