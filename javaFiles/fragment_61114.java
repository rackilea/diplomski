boolean validInput = false;
do {
    try {
        System.out.print("Enter your favourite number: ");
        favorite = scan.nextInt();
        validInput = true; }
    catch (Exception e) {
        System.out.println("Enter an integer!"); }
} while (!validInput)