static class MyCustomMatcher {
    // bits needed = last character + 1
    private static final BitSet matcher = new BitSet('ü' + 1);

    static {
        String other = " \r\nÑÉñà@£$¥èéùìò_!\"#%&',()*+-./:;<=>?§`€[]{|}^~\ßÄÖÜäöü";
        matcher.set(c, 'A', 'Z' + 1); // upper
        matcher.set(c, 'a', 'z' + 1); // lower
        matcher.set(c, '0', '9' + 1); // digit
        for (int i = 0; i < other.length(); i++) matcher.set(other.charAt(i));
    }

    public static boolean matchesAll(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!matcher.get(s.charAt(i))) return false;
        }
        return true;
    }
}