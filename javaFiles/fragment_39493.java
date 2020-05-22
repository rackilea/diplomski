public String processReader(Reader reader) throws IOException {
    char[] arr = new char[8 * 1024]; // 8K at a time
    StringBuffer buf = new StringBuffer();
    int numChars;
    while ((numChars = reader.read(arr, 0, arr.length)) > 0) {
        buf.append(arr, 0, numChars);
    }
    return lemmatizer.getLemma(buf.toString());
}