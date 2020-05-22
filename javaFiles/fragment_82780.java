public static String removeDiacritic(String source) {
    char[] vysl = new char[source.length()];
    char one;
    for (int i = 0; i < source.length(); i++) {
        one = source.charAt(i);
        if (one >= '\u00c0' && one <= '\u017f') {
            one = tab00c0.charAt((int) one - '\u00c0');
        }
        vysl[i] = one;
    }
    return new String(vysl);
}