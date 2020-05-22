public static String readExactly(Reader reader, int length) throws IOException {
    char[] chars = new char[length];
    int offset = 0;
    while (offset < length) {
        int charsRead = reader.read(chars, offset, length - offset);
        if (charsRead <= 0) {
            throw new IOException("Stream terminated early");
        }
        offset += charsRead;
    }
    return new String(chars);
}