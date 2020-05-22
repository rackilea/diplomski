public static boolean hasNonWordCharacter(String s) {
    char[] a = s.toCharArray();
    for (char c : a) {
        if (!Character.isLetter(c)) {
            return true;
        }
    }

    return false;
}