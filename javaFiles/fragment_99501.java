private int readIntBetweenMinAndMax(String msg, int min, int max) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(msg);
    int userInput;
    do {
        try {
            userInput = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Please enter a valid integer");
            continue;
        }
        if (userInput > max || userInput < min) {
            System.err.println("Please enter a integer between " + min + " and " + max);
            continue;
        }
        return userInput;
    } while (true);
}