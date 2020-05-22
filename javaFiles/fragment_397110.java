public static void main(String[] args) {
    boolean run = true;
    Scanner scanner = new Scanner(System.in); // Init before loops
    String userInput = ""; // tmp var that holds input

    while (run) {
        // do something

        System.out.println("Another action? [Y/N]");
        userInput = scanner.next(); // Read first time

        // Run while user does not put Y || y || N || n
        while (!userInput.matches("[YyNn]")){
            System.out.println("Incorrect input");
            userInput = scanner.next();
        }

        // User does not want more actions
        if(userInput.matches("[Nn]")){
            System.out.println("Do you wish to exit the program? [Y/Any other key]");
            String choice = scanner.next();

            // Stop the program
            if (choice.toLowerCase().equals("y"))
                run = false;
        }
    }
    scanner.close(); // Close scanner outside
}