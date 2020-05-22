for (int i = 0; i <= stringArray.length; i++) {

        boolean isInArray = false;

        System.out.println("\nEnter a string");
        String input = keyboard.next();

        if (i > 0) {

            for (int j = 0; j < stringArray.length; j++) {
                if (stringArray[j].equalsIgnoreCase(input)) {
                    isInArray = true;
                    break;
                }
            }
        }
        if (!isInArray) {
            stringArray[stringNumber] = input;
        } else {
            System.out.println("\"" + stringArray[stringNumber-1] + "\""
                    + " has been stored.");
        }
        PrintArray(stringArray);
        stringNumber++;
    }