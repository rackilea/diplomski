if (password.equals(CORRECT_PWORD)) {
    System.out.println("Welcome to Favor Stuff (Party Giveaways)!");
    String option = null;
    do {
        System.out.println("Please select from the available options below! ");
        System.out.println("A. Truffled Boxes");
        System.out.println("B. Candy Jars");
        System.out.println("C. Jellies");
        System.out.println("D. Cupcakes");
        System.out.println("E. Bride and Groom");
        System.out.println("X. Exit");
        option = keyboard.nextLine();
        if (option.equals("A")) {
            String subOption = null;
            do {
                System.out.println("1. Truffled Boxes with two (2) truffles and personalized thank you tags");
                System.out.println("2. Truffled Boxes with four (4) truffles and personalized thank you tags");
                System.out.println("3. Truffled Boxes with six (6) truffles and personalized thank you tags");
                System.out.println("0. Return");
                subOption = keyboard.nextLine();
                if (subOption.equals("1")) {

                } else if (subOption.equals("2")) {
                } else if (subOption.equals("3")) {
                } else if (subOption.equals("0")) {
                // Do nothing, but don't want to display
                    // invalid entry message
                } else {
                    System.out.println("Invalid entry!");
                }
            } while (!subOption.equalsIgnoreCase("0"));
        } else if (option.equals("B")) {
            // Candy jars...
        } else if (option.equals("C")) {
            // Jellies...
        } else if (option.equals("D")) {
            // Candy Cupcakes...
        } else if (option.equals("E")) {
            // Bride groom...
        } else if (option.equalsIgnoreCase("x")) {
        // Do nothing, but don't want to display
            // invalid entry message
        } else {
            System.out.println("Invalid entry!");
        }
    } while (!option.equalsIgnoreCase("x"));
}