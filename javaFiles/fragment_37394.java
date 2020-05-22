public static void main(String... args) {
    System.out.println(toggleBits("1010"));
    System.out.println(toggleBits("00001010"));
    System.out.println(toggleBits("1100001010"));
}

private static String toggleBits(String s) {
    long i = Long.parseLong(s, 2);
    long i2 = i ^ ((1L << s.length()) - 1);
    String s2 = Long.toBinaryString(i2);
    while (s2.length() < s.length()) s2 = '0' + s2;
    return s2;
}