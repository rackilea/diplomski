public static void main(String[] args) {
    for (byte i = 0; i <= 16; i++) {
        int i1 = i >> 1;
        int i2 = i1 << 6;
        int i3 = i2 >> 5;
        System.out.printf("%3d %s -> %3d %s -> %3d %10s -> %3d %s%n", i, bin(i), i1, bin(i1), i2, bin(i2), i3, bin(i3));
    }
}
private static String bin(int value) {
    String s = Integer.toBinaryString(value);
    return "0000000".substring(Math.min(7, s.length() - 1)) + s;
}