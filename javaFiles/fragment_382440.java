/**
 * Minimize the String output obtained from running a JUnit test suite
 * 
 * @param input
 *            The String produced from running a JUnit test suite
 * @return A String that has been minimized to contain the method that
 *         contains the failing assertion and the assertion that failed
 */
private static String minimizeJUnitOutput(String input) {
    Scanner scn = new Scanner(input);

    // JUnit output starts with index 1 for first failure
    int index = 1;
    // String to represent the result that we return
    String res = "";
    // Continue until we finish processing the input String
    while (scn.hasNextLine()) {
        String line = scn.nextLine();
        // Look for a String of the form i) where i is the current failing
        // test index
        if (line.startsWith(index + ") ")) {
            res += line + "\n" + scn.nextLine() + "\n";
            index++;
        }
    }
    scn.close();
    return res;
}