for (int read = 0; read < fileBytes.length;) {
    numRead = diStream.read(fileBytes, read, fileBytes.length - read);
    if (numRead >= 0) {
        read = read + numRead;
    }
}