public byte[] intToByteArray(final int i) throws java.io.IOException {
    java.io.ByteArrayOutputStream b = new java.io.ByteArrayOutputStream();
    java.io.DataOutputStream d = new java.io.DataOutputStream(b);
    d.writeInt(i);
    d.flush();

    return b.toByteArray();
}