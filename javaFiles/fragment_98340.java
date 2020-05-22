public static byte[] cyclicResize(byte[] input, int length) {
    byte[] result = new byte[length];
    for (int i = 0; i < length; i++) {
        result[i] = input[i % input.length];
    }
    return result;
}