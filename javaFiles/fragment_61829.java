public void copy(YourFileType file, OutputStream os) throws IOException {
    try (InputStream fileContent = file.getContentAsStream()) {
        byte[] buffer = new byte[4096]; // 4096 is kind of a magic number
        int readBytesCount = 0;
        while((readBytesCount = fileContent.read(buffer)) >= 0) {
            os.write(buffer, 0, readBytesCount);
        }
    }
}