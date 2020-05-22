public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        int numOfArguments = getNumberOfArguments(scanner);
        int sum = getNextNumberFromUser(scanner, 1);
        for (int i = 2; i <= numOfArguments; i++) {
            sum -= getNextNumberFromUser(scanner, i);
        }
        System.out.println("Answer is: " + sum + "\n\nDo you want to continue?(Y/N): ");
        String runAgain = scanner.next();
        if (runAgain.equalsIgnoreCase("N")) {
            break;
        }
    }
}

private static int getNextNumberFromUser(Scanner scanner, int i) {
    while (true) {
        try {
            System.out.println("Enter number " + i + " : ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Entry. Try again!!");
            scanner.nextLine();
        }
    }
}

private static int getNumberOfArguments(Scanner scanner) {
    int numberOfArguments = -1;
    System.out.println("Enter how many numbers to Subtract?: ");
    while (numberOfArguments == -1) {
        try {
            numberOfArguments = scanner.nextInt();
            if (numberOfArguments <= 0) {
                numberOfArguments = -1;
            }
        } catch (InputMismatchException e) {
            System.out.println("Illegal number of arguments to subtract, please try again: ");
            scanner.nextLine();
        }
    }
    return numberOfArguments;
}