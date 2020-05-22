public static void main(String[] args) {
    for (byte i = 0; i <= 16; i++) {
        byte i1 = (byte)(i >> 1);
        byte i2 = (byte)(i1 << 6);
        byte i3 = (byte)(i2 >> 5);
        System.out.printf("%3d %s -> %3d %s -> %4d %s -> %3d %s%n", i, bin(i), i1, bin(i1), i2, bin(i2), i3, bin(i3));
    }
}
private static String bin(byte value) {
    String s = Integer.toBinaryString(value & 0xFF);
    return "0000000".substring(s.length() - 1) + s;
}