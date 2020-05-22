public static int seqSearchPos(String s, char c) {
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == c) {
            return i;
        }
    }
    return -1;
}