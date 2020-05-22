public static boolean containsOnly(String s, String only) {
    for (int i = 0; i < s.length(); i++) {
        if (only.indexOf(s.charAt(i)) == -1)
            return false;
    }
    return true;
}