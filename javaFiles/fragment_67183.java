// checking for whitespace like String.trim() does
private static boolean isWhitespace(String s) {
    int length = s.length();
    if (length > 0) {
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) > ' ') {
                return false;
            }
        }
        return true;
    }
    return false;
}