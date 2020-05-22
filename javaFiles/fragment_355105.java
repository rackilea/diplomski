public void process(int data) {
    byte[] bytes = ByteBuffer.allocate(Integer.BYTES)
                             .order(ByteOrder.LITTLE_ENDIAN)
                             .putInt(data)
                             .array();

    sha.update(bytes, 0, bytes.length);
}