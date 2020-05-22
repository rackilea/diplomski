private InputStream getInIfOpen() throws IOException {
    InputStream input = in;
    if (input == null)
        throw new IOException("Stream closed");
        return input;
    }