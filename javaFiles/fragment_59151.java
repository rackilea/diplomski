int[] unsign(byte[] bytes) {
    int[] unsignedBytes = new int[bytes.length];

    for(int i = 0; i < unsignedBytes.length; i++) {
        unsignedBytes[i] = bytes[i] & 0xff;
    }

    return unsignedBytes;
}