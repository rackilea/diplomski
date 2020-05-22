public static boolean containsOneOrMore(String text, String[] search) {
    for (String s : search) {
        if (!text.contains(s)) {
            return false;
        }
    }
    return true;
}