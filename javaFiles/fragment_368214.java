private static void print(byte[] bcd) {
    for (int i = 0; i < bcd.length; i++) {
        if (i != 0)
            System.out.print(' ');
        System.out.printf("%02x", bcd[i]);
    }
    System.out.println();
}
public static void main(String[] args) {
    byte[] bcd1 = { 0x00, 0x00, 0x00, 0x01, 0x23 }; // decimal 123
    for (int i = 0; i < 10; i++) {
        increment(bcd1);
        print(bcd1);
    }
    byte[] bcd2 = { (byte)0x99, (byte)0x99, (byte)0x99, (byte)0x99, (byte)0x95 }; // decimal 9_999_999_995
    for (int i = 0; i < 10; i++) {
        increment(bcd2);
        print(bcd2);
    }
}