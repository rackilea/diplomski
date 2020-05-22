int option = 0; // don't read the value directly before validating that is actually an integer value or you will get the InputMismatchException

if (!myscan.hasNextInt()) {
    System.out.println("Error, this is not an integer:");
    myscan.nextLine(); // consume the \n
    continue; // loop again
} else {
    option = myscan.nextInt();
}