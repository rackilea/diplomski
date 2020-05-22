public static boolean isProperlyNested(String toTest) {
    int countOpen = 0;
    for (char c : toTest.toCharArray()) {
        if (c == '{') {
            countOpen++;
        } else if (c == '}') {
            countOpen--;
            if (countOpen < 0) return false;
        }
    }
    return countOpen == 0;
}