private static final byte PADDING_BYTE = (byte) 0xFF;

private static int determineUnpaddedEnd(byte[] array, int start, int end) {
    // end is exclusive
    int paddingOffset = end - 1;
    while (paddingOffset >= start
            && array[paddingOffset] == PADDING_BYTE) {
        paddingOffset--;
    }
    // returns either start or the location of the last padding byte
    return paddingOffset + 1;
}

private static byte[] removePadding(byte[] array) {
    int unpaddedEnd = determineUnpaddedEnd(array, 0, array.length);
    return Arrays.copyOf(array, unpaddedEnd);
}

private static ByteBuffer removePadding(ByteBuffer buf) {
    int start = buf.position();
    int paddingOffset = buf.limit() -1;
    while (paddingOffset >= start
            && buf.get(paddingOffset) == PADDING_BYTE) {
        paddingOffset--;
    }
    buf.limit(paddingOffset + 1);
    return buf;
}

public static void main(String[] args) {
    Map<byte[], Integer> testVectors = new HashMap<>();
    testVectors.put(new byte[0], 0);
    testVectors.put(new byte[] {-1}, 0);
    testVectors.put(new byte[] {1, -1}, 1);
    testVectors.put(new byte[] {83, 97, 103, 117, 110, -1, -1, -1}, 5);

    int testcase = 1;
    for (Entry<byte[], Integer> test : testVectors.entrySet()) {
        System.out.println(testcase++);
        byte[] array = test.getKey();
        int value = determineUnpaddedEnd(array, 0, array.length);
        if (value != test.getValue()) {
            throw new IllegalStateException("Maarten cannot program anymore");
        }
        System.out.println(Arrays.toString(removePadding(array)));
        System.out.println(removePadding(ByteBuffer.wrap(array)));
    }
}