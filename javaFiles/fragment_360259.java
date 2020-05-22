public void increment() {
    num = increment(num);
}
private static String increment(String s) {
    if (s.length() <= 0) return "1";
    char ch = s.charAt(s.length() - 1);
    String top = s.substring(0, s.length() - 1);
    return ch < '9' ? top + ++ch : increment(top) + '0';
}