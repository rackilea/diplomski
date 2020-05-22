private static void printCoordinateInfo(BigInteger bigInteger, String coordinateName) {
    String bitString = bigInteger.toString(2);
    String binary = fillZeros(bitString, 264);
    byte[] coordinateBytes = bigInteger.toByteArray();

    System.out.println(coordinateName + " byte array length " + coordinateBytes.length);
    System.out.println(coordinateName + " bit string length " + binary.length());
    System.out.println(binary);
}

private static String fillZeros(String text, int size) { //fills with zeros on the left and quits when achieves given length
    StringBuilder builder = new StringBuilder(text);
    while (builder.length() < size) {
        builder.insert(0, '0');
    }
    return builder.toString();
}