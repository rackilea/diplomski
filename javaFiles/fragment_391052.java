boolean validIntegerEntered = false;
System.out.println("ENTER A NUMBER: ");
while (!validIntegerEntered) {
    try {
        n=input.nextInt();
        validIntegerEntered = true;  // will not get here if nextInt()
                                     // throws an exception
    }
    catch (InputMismatchException e) {
        input.nextLine();            // let the scanner skip over the bad input
        System.out.println("ERROR!!! \nENTER A NUMBER :");
        // don't call nextInt() here; loop back, and nextInt() will be called
        // in the try statement
    }
}