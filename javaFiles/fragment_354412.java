public static byte[] split(byte input) {
    byte[] output = new byte[2];

    output[0] = (byte) (input & -16);
    output[1] = (byte) (input & 15);

    return output;
}