public byte[] getDataSendBytes(String text) {
    try {
        byte[] bytes = text.getBytes("UTF-8");
        ByteBuffer bb = ByteBuffer.allocate(4 + bytes.length).order(ByteOrder.LITTLE_ENDIAN);
        bb.putInt(bytes.length);
        bb.put(bytes);
        return bb.array();
    } catch (UnsupportedEncodingException e) {
        throw new AssertionError(e);
    }
}