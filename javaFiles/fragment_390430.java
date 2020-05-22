for (int n=0; n < wordLetters.length; n++) {
        while (!userInput.hasNextLine()) {
            System.out.println("Please enter letters only.");
        }
        String userChoice = userInput.nextLine();

        if (wordLetters[n] == userChoice.charAt(0)) {
            System.out.println("You've made a match");
        } else {
            System.out.println("Sorry, try again.");
        }
    }