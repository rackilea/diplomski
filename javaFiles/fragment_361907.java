private static String changeStringAndReturn(String s) {
    return new String("new string");
}
private static void changeStringInArray(String[] s) {
    if (null != s && 0 < s.length) {
        s[0] = new String("new string");
    }
}