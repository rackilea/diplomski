Scanner s = new Scanner(System.in);
    int maxCount = 20;
    // initialize it to a random value for now
    String input = "?";
    System.out.println("Enter 2 cities with cost upto 20");
    while (!input.trim().equals("") && maxCount > 0) {
        input = s.nextLine();
        /*
         *  parse input accordingly
         */
        maxCount--;
    }
    System.out.println("Done with input");