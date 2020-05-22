int[] intArray = new int[3];
    int counter = 0;
    boolean enterPressed = false; // added boolean to test if they entered a blank line

    try (
            Scanner sc = new Scanner(System.in); // declaring in a try-with-resources, so it automatically closes.
        ) {

        System.out.println("Start!!");
        System.out.println("Enter int"); // Have to print this the first time
        while (counter < 3 && !enterPressed) {
            if (counter > 0) { System.out.println("Enter int"); }
            String next = sc.nextLine(); // just grab a line (the user pressed enter)
            if (next.isEmpty()) {
                enterPressed = true;
            } else {
                try {
                    intArray[counter] = Integer.parseInt(next);
                    counter++;
                } catch (NumberFormatException ex) {
                    System.out.println("wrong input.");
                }
            }
        } 
    }