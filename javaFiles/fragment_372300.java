public static int countCharInString(String s, char c, int index) {
    if (index == s.length()) {
        return 0;
    }
    if (s.charAt(index) == c) {
        return 1 + countCharInString(s, c, index + 1);
    } else {
        return countCharInString(s, c, index + 1);
    }
}