int compVal = (int) (3 * Math.random()) + 1;
        int userOriginal = 0;
        String userInput = (keyboard.nextLine().toUpperCase());

        switch (userInput) {
        case "R":
            userOriginal = 1;
            break;
        case "P":
            userOriginal = 2;
            break;
        case "S":
            userOriginal = 3;
            break;
        default:
            System.out.println("Invalid input, please try again!");
            System.exit(1); // This will exit the program
        }