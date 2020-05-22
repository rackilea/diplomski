public int byteArrayToInt(final byte[] b) throws IOException {
    java.io.ByteArrayInputStream ba = new java.io.ByteArrayInputStream(b);
    java.io.DataInputStream d = new java.io.DataInputStream(ba);

    return d.readInt();
}