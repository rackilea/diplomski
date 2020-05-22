public byte[] encode() {
    final int MESSAGE_SIZE = 10;
    int portValue = 54321;
    Bytebuffer buffer = ByteBuffer.allocate(MESSAGE_SIZE);
    buffer.putInt(someInt);
    buffer.putShort((short) portValue);
    buffer.putInt(someOtherInt); 
    return buffer.array();
}