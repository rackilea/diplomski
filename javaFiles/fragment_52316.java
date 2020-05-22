byte[] bytes = {72, -26, -90, 56, 69, 98, 5, -67, 49, 43, -127, 54, -19, 2, -109, -26};
for (int i = 0; i < bytes.length / 2; i++) {
    byte temp = bytes[i];
    bytes[i] = bytes[bytes.length - i - 1];
    bytes[bytes.length - i - 1] = temp;
}
System.out.println(new BigInteger(1, bytes));