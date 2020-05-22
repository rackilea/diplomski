Scanner input = new Scanner(System.in);
String inputSSN = "";

while (inputSSN.equals("")) {
    System.out.print("Enter a Social Security Number: --> ");
    inputSSN = input.nextLine();

    // Validate SSN...
    for (int i = 0; i < inputSSN.length(); i++) {
        // Validate the first set of 3 digits
        if (i >= 0 && i <= 2) {
            if (!Character.isDigit(inputSSN.charAt(i))) {
                inputSSN = "";
                break;
            }
            continue;
        }

        // Validate the first hyphen
        if (i == 3 && inputSSN.charAt(i) != '-') {
            inputSSN = "";
            break;
        }

        // Validate the second set of 2 digits
        if (i >= 4 && i <= 5) {
            if (!Character.isDigit(inputSSN.charAt(i))) {
                inputSSN = "";
                break;
            }
            continue;
        }

        // Validate the second hyphen
        if (i == 6 && inputSSN.charAt(i) != '-') {
            inputSSN = "";
            break;
        }

        // Validate the third set of 4 digits
        if (i >= 7 && i <= 10) {
            if (!Character.isDigit(inputSSN.charAt(i))) {
                inputSSN = "";
                break;
            }
        }
    }

    // Validate that the SSN is the right length
    if (inputSSN.length() != 11) {
        System.out.println("Invalid Social Security Number!" + System.lineSeparator());
        inputSSN = "";
    }
}

System.out.println(inputSSN + " is a valid Social Security Number.");