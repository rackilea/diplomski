public String replaceBetween(String inputString, String openChar, 
                             String closeChar, String[][] replacements) {
    // If the supplied input String contains nothing
    // then return a Null String ("").
    if (inputString.isEmpty()) { return ""; }

    // Declare a string to hold the input string, this way
    // we can freely manipulate it without jeopordizing the
    // original input string.
    String inString = inputString;

    // Set the escape character (\) for RegEx special Characters
    // for both the openChar and closeChar parameters in case
    // a character in each was supplied that is a special RegEx
    // character. We'll use RegEx to do this.
    Pattern regExChars = Pattern.compile("[{}()\\[\\].+*?^$\\\\|]");
    String opnChar = regExChars.matcher(openChar).replaceAll("\\\\$0");
    String clsChar = regExChars.matcher(closeChar).replaceAll("\\\\$0");

    // Create our Pattern to find the items contained between
    // the characters tht was supplied in the openChar and
    // closeChar parameters.
    Matcher m = Pattern.compile(opnChar + "([^" + closeChar + "]+)" + clsChar).matcher(inString);

    // Iterate through the located items...
    while(m.find()) {
        String found = m.group(1);
        // Lets see if the found item is contained within
        // our supplied 2D replacement items Array... 
        for (int i = 0; i < replacements.length; i++) {
            // Is an item found in the array?
            if (replacements[i][0].equals(found)) {
                // Yup... so lets replace the found item in our 
                // input string with the related element in our
                // replacement array.
                inString = inString.replace(openChar + found + closeChar, replacements[i][1]);
            }
        }
    }
    // Return the modified input string.
    return inString;
}