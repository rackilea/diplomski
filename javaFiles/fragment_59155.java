byte[] sign(int[] unsignedBytes) {
    byte[] signedBytes = new byte[unsignedBytes.length];

    for(int i = 0; i < signedBytes.length; i++) {
        signedBytes[i] = (byte) unsignedBytes[i];
    }

    return signedBytes;
}