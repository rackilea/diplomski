static void printByteArray(byte[] bytes) {
    for (byte b : bytes) {
        System.out.print(Integer.toHexString(b & 0xff) + ", ");
    }
    System.out.println();
}

public static void main(String[] args) {

    byte[] cipherBytes = Base64.getDecoder().decode("yOBIc4FY");
    printByteArray(cipherBytes); // c8, e0, 48, 73, 81, 58 - correct

    cipherBytes = new String(cipherBytes).getBytes();
    printByteArray(cipherBytes); // c8, e0, 48, 73, 3f, 58 - wrong
    // your results may vary depending on your default charset,
    // these are for windows-1250
}