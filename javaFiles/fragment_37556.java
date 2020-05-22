public static int countCharacterOutsideQuotes(CharSequence chars, char targetChar) {
    int count = 0;
    boolean isQuoted = false;
    // using `charAt` avoids doubling memory usage of copying all the chars into another array
    for (int i = 0; i < chars.length(); i++) {
        char c = chars.charAt(i);
        if (c == '"') {
            // found a quote, flip from not quoted to quoted or vice versa.
            isQuoted = !isQuoted;
        } else if (c == targetChar && !isQuoted) {
            // found the target character, if it's not inside quotes then count it
            count++;
        }
    }
    return count;
}