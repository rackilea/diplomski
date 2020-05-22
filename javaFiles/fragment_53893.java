int bytesRead = 0;
while (bytesRead < bytes.length) {
    int chunk = _input.read(bytes, bytesRead, bytes.length - bytesRead);
    if (chunk == -1) {
        throw new IOException("Didn't get as much data as we should have");
    }
    bytesRead += chunk;
}