private byte[] readResponse(HttpURLConnection connection) throws IOException {
    InputStream inputStream = connection.getInputStream();
    int contentLength = connection.getContentLength();
    byte[] buffer;
    buffer = new byte[contentLength];
    int bufferSize = 1024;
    int bytesRemaining = contentLength;
    int loadedBytes;
    for (int i = 0; i < contentLength; i = i + loadedBytes) {
        int readCount =   bytesRemaining > bufferSize ? bufferSize : bytesRemaining;
        loadedBytes = inputStream.read(buffer, i , readCount);
        bytesRemaining = bytesRemaining - loadedBytes;
    }
    return buffer;
}