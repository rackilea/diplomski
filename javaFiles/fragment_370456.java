// Assuming you now have a field of type Reader, called reader
private String readEntry() throws IOException {
    char[] buffer = new char[10];
    int index = 0;
    while (index < buffer.length) {
        int charsRead = reader.read(buffer, index, buffer.length - index);
        if (charsRead == -1) {
            throw new IOException("Couldn't read entry - end of data");
        }
        index += charsRead;
    }
    return new String(buffer);
}