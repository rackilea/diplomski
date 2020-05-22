FileOutputStream outputStream = null;
try {
    outputStream = new FileOutputStream(fileLoc);
    outputStream.write(content.getBytes());
    outputStream.flush();
} finally {
    if (outputStream != null) {
        outputStream.close();
    }
}