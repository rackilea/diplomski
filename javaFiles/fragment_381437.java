int readCount = 0;
int BUFFER_SIZE = 256;
StringBuilder sb = new StringBuilder();
CharsetDecoder dec=StandardCharsets.UTF_8.newDecoder();
ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
CharBuffer cBuffer= CharBuffer.allocate(BUFFER_SIZE);
ReadableByteChannel readableByteChannel = Channels.newChannel(is);
while(readableByteChannel.read(buffer) > 0 && readCount < 68) {
    buffer.flip();
    while(dec.decode(buffer, cBuffer, false).isOverflow()) {
        cBuffer.flip();
        sb.append(cBuffer);
        cBuffer.clear();
    }
    buffer.compact();
    readCount++;
}
buffer.flip();
for(boolean more=true; more; ) {
    more=dec.decode(buffer, cBuffer, true).isOverflow();
    cBuffer.flip();
    sb.append(cBuffer);
    cBuffer.clear();
}