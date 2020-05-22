public static boolean containsAny(String s, String... words) {
    for (String word : words) {
        if (s.contains(word))
            return true;
    }
    return false;
}