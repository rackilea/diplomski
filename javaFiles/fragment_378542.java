private void analyzePlantName(LinkedList<Plant> plantLinkedList) {

        /*
        This method will take a String as user input, loop through the LinkedList, and (if it exists in the List) display the counts of the specified substrings.
        If the String is not found, it will display an ERROR message and recursively call the method again.
         */

        System.out.println("Analysis for substrings 'e', 'o', 'er', and 'ar'.\n"); //Let's the user know which substrings are being searched/counted.
        System.out.println("Enter the plant name you wish to analyze: ");
        String analysisString = input.next().trim(); //first try to input
        analysisString = analysisString.toLowerCase();

        int countLetterE = 0; //initialize counters
        int countLetterO = 0;
        int countLetterER = 0;
        int countLetterAR = 0;
        Pattern patternER = Pattern.compile("\\Ber\\B"); //create non-word boundary for substring "er"
        Pattern patternAR = Pattern.compile("\\Bar\\B"); //create non-word boundary for substring "ar"
        Matcher matchER = patternER.matcher(analysisString);
        Matcher matchAR = patternAR.matcher(analysisString);

        boolean validInput = false; //initialize boolean variable

        for (int i = 0; i < plantLinkedList.size(); i++) {
            if (plantLinkedList.get(i).getName().equalsIgnoreCase(analysisString)) { //loop through List to match user String with plant name
                validInput = true; //if found, break out of loop
                break;
            }
        }
        if (validInput) { //if conditions are met, count substrings and display

            while(matchER.find()) { //loop through analysisString and increment each time pattern "er" is found
                countLetterER++;
            }
            while(matchAR.find()) { //loop through analysisString and increment each time pattern "ar" is found
                countLetterAR++;
            }
            /*
            Separate loop for single chars
             */
            for (int i = 0; i < analysisString.length(); i++) { 
                if (analysisString.charAt(i) == 'e') {
                    countLetterE++;
                }
                if (analysisString.charAt(i) == 'o') {
                    countLetterO++;
                }
            }
            System.out.println("Analysis of '" + analysisString + "'\n");

            System.out.println("'e' - " + countLetterE + " | 'o' - " + countLetterO + " | 'er' - " + countLetterER + " | 'ar' - " + countLetterAR + "\n"); //this all works fine.
        } else {
            System.out.println("ERROR. You must enter a valid plant name.\n");
            System.out.print("Please try again.\n");
            analyzePlantName(plantLinkedList); //recursive method call
        }
    }