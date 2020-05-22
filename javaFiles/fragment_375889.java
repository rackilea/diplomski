/**
 * Validates the User's Row and Column values input. This method checks to
 * ensure only numerical characters were entered. It also ensures the the
 * numerical value entered is between and or equal to the supplied minValue
 * and maxValue.
 *
 * @param minVal      (Integer) The minium Allowable integer value to be
 *                    entered.
 * @param maxVal      (Integer) The maximum allowable integer value to be
 *                    entered.
 * @param inputString (String) String representation of the integer value
 *                    supplied.
 *
 * @return (Boolean) True if the entry is valid and false if it is not.
 */
private static boolean validateUserRowColInput(int minVal, int maxVal, String inputString) {
    String LS = System.lineSeparator();
    if (inputString.equals("")) {
        System.out.println("Invalid Entry! You must supply a numerical "
                + "value from " + minVal + " to " + maxVal + ".");
        return false;
    }
    if (inputString.equalsIgnoreCase("q") || inputString.equalsIgnoreCase("quit")) {
        System.out.println("We hope you had fun. Bye Bye");
        System.exit(0);
    }
    if (!inputString.matches("\\d+")) {
        System.out.println("Invalid input supplied (" + inputString + ")! "
                + "You can not supply alpha characters, only" + LS 
                + "numerical values are allowed!. Please try again...");
        return false;
    }
    int num = Integer.parseInt(inputString);
    if (num < minVal || num > maxVal) {
        System.out.println("Invalid input supplied (" + inputString + ")! "
                + "The numerical value you supply can not be" + LS + "less "
                + "than " + minVal + " and no greater than " + maxVal + ". "
                + "Please try again...");
        return false;
    }
    return true;
}