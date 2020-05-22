public static String subStringFinder(String word) {
    if (word == null || word.isEmpty()) {
        return word;
    }
    char currentChar = word.charAt(0);
    int longestStart = 0;
    int longestLength = 0;
    int currentStart = 0;
    int currentLength = 1;
    for (int ix = 1; ix < word.length(); ix++) {
        if (word.charAt(ix) == currentChar) {
            currentLength++;
        } else {
            if (currentLength > longestLength) {
                longestStart = currentStart;
                longestLength = currentLength;
            }
            currentChar = word.charAt(ix);
            currentStart = ix;
            currentLength = 1;
        }
    }
    if (currentLength > longestLength) {
        longestStart = currentStart;
        longestLength = currentLength;
    }
    return word.substring(longestStart, longestStart + longestLength);
}