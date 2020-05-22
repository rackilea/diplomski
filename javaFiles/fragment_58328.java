try {
    System.out.print("Enter an integer number: ");
    long i = in.nextLong();
    System.out.print("Thanks, you entered: ");
    System.out.println(i);
    break;
} catch (InputMismatchException ex) {
    System.out.println("Error in your input");
    in.next(); // Read and discard whatever string the user has entered
}