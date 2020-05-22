private static boolean isWhitespace(String s) {
    int length = s.length();
    if (length > 0) {
        for (int start = 0, middle = length / 2, end = length - 1; start <= middle; start++, end--) {
            if (s.charAt(start) > ' ' || s.charAt(end) > ' ') {
                return false;
            }
        }
        return true;
    }
    return false;
}