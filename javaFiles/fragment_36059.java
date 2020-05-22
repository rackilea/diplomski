public static int countOccurrences(String text, char character) {
    int count = 0;
    for (int i = 0; i < text.length(); i++) {
        if (text.charAt(i) == character) {
            count++;
        }
    }
    return count;
}