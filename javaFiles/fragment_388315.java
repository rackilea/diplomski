public static void tryEncoding(final String encoding) throws UnsupportedEncodingException {
    int badCount = 0;
    for (int i = 1; i < 255; i++) {
        byte[] bytes = new byte[] { (byte) i };

        String toString = new String(bytes, encoding);
        byte[] fromString = toString.getBytes(encoding);

        if (!Arrays.equals(bytes, fromString)) {
            System.out.println("Can't encode: " + i + " - in: " + Arrays.toString(bytes) + "/ out: "
                    + Arrays.toString(fromString) + " - result: " + toString);
            badCount++;
        }
    }

    System.out.println("Bad count: " + badCount);
}