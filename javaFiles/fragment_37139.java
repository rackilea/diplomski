public static void main(String[] args) {

    boolean repeat = true;

    while (repeat) {
        /* print game results here */
        System.out.println("results: here!");
        repeat = rLoop();
    }
}




private static boolean rLoop() {

    String input;
    boolean repeat = false;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Would you like to play again?");
    System.out.printf("Either [Y]es or any other key to exit.");
    input = keyboard.nextLine();

    if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes"))
        repeat = true;
    else
        repeat = false;

    return repeat;
}