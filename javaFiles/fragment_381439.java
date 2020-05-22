int readCount = 0;
int BUFFER_SIZE = 256;
StringBuilder sb = new StringBuilder();
CharBuffer cBuffer = CharBuffer.allocate(BUFFER_SIZE);
Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
while(reader.read(cBuffer) > 0 && readCount < 68) {
    cBuffer.flip();
    sb.append(cBuffer);
    cBuffer.clear();
    readCount++;
}