public byte[] getDataSendBytes(String text) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
        new DataOutputStream(baos).writeUTF(text);
    } catch (IOException e) {
        throw new AssertionError(e);
    }
    return baos.toByteArray();
}