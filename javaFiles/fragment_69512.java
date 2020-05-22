while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
    if (choice.isEmpty()) {
        System.out.println("Error! This entry is required. Try again.");
    } else {
        System.out.println("Error! Please enter y, Y, n, or N. Try again.");
    }

    choice = sc.nextLine(); 
}