private static int testMarkDickinson(String x, int y) {
    int acc = 0;
    for (int i = 0; i < x.length(); i++)
        acc = (acc * 10 + x.charAt(i) - '0') % y;
    return acc;
}

private static int testHovercraftFullOfEels(String x, int y) {
    return new BigInteger(x).divideAndRemainder(BigInteger.valueOf(y))[1].intValue();
}

private static int testMrM(String x, int y) {
    String s = x;
    while (s.length() >= 7) {
        int len = Math.min(9, s.length());
        s = Integer.parseInt(s.substring(0, len)) % y + s.substring(len);
    }
    return Integer.parseInt(s) % y;
}