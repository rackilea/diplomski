public static String commonSuffixWithRecursion(String s1, String s2) {
    if (s1.length() == 0 || s2.length() == 0) {
        return "";
    }
    if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
        String nextS1 = s1.substring(0, s1.length() - 1);
        String nextS2 = s2.substring(0, s2.length() - 1);
        return commonSuffixWithRecursion(nextS1, nextS2 ) + s1.charAt(s1.length() - 1);
    }
    return "";
}