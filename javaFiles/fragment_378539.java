public static List<String> filterSpecialCharacters(List<String> input) {
    Iterator<String> it = input.iterator();
    List<String> output = new ArrayList<String>();
    // For all strings in the List
    while (it.hasNext()) {
        String s = it.next();
        int endIndex = s.length() - 1;
        // Get the last index of alpha numeric char
        for (int i = endIndex; i >= 0; i--) {
            if (isAlphaNumeric(s.charAt(i))) {
                endIndex = i;
                break;
            }
        }
        StringBuilder out = new StringBuilder();
        boolean startCopying = false;
        // Parse the string till the last index of alpha numeric char
        for (int i = 0; i <= endIndex; i++) {
            // Ignore the leading occurrences non alpha-num chars
            if (!startCopying && !isAlphaNumeric(s.charAt(i))) {
                continue;
            }
            // Start copying to output buffer after(including) the first occurrence of alpha-num char 
            else {
                startCopying = true;
                out.append(s.charAt(i));
            }
        }
        // Add the trimmed string to the output list.
        output.add(out.toString());
    }

    return output;
}

// Updated this method with the characters that you dont want to trim
private static boolean isAlphaNumeric(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
}