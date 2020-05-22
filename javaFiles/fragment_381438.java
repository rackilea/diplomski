int readCount = 0;
int BUFFER_SIZE = 256;
StringBuilder sb = new StringBuilder();
CharBuffer cBuffer= CharBuffer.allocate(BUFFER_SIZE);
ReadableByteChannel readableByteChannel = Channels.newChannel(is);
Reader reader=Channels.newReader(readableByteChannel, "UTF-8");
while(reader.read(cBuffer) > 0 && readCount < 68) {
    cBuffer.flip();
    sb.append(cBuffer);
    cBuffer.clear();
    readCount++;
}