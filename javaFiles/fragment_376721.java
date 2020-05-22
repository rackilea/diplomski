Scanner in = new Scanner(System.in);
    int lives = 0;
    boolean isNumber = false;
    do {
        System.out.println("How many lives do you currently have? (Max. 4): ");
        if (in.hasNextLine()) { // when enter key has been hit
            try {
                lives = Integer.parseInt(in.nextLine().trim());
                if (lives < 1  || lives > 4) {
                    System.out.println("Please try again. Number must be between 1 and 4");
                    isNumber = false;
                } else {
                    isNumber = true;
                }
            } catch (NumberFormatException e) {
                //Report your error here to the user
                System.out.println("Please enter a number");
                isNumber = false;
            }
        } 

    } while (!(isNumber));