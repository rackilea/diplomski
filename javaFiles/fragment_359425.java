// InputStream doesn't actually have a seek method, but I'll assume you're using
// a subclass which does...
inputStream.seek(position);
while (true) {
    int nextByte = inputStream.read();
    if (nextByte == -1 || (nextByte & 0xc0) != 0xc0) {
       break;
    }
    position++;
}
// Undo the last read, effectively
inputStream.seek(position);
InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);