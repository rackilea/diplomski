public boolean promptForContinue(final Scanner keyboard) {
    boolean isValid = false;
    String userInput = "";
    do {
        userInput = keyboard.next();

        isValid = userInput.matches("Yes|No");

        if (!isValid) {
            System.out.println("Invalid entry.");
        }
    } while (!isValid);

    return userInput.equals("Yes") ? true : false;
}