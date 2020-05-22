try (InputStream urlStream = new URL(s3Url).openStream();
     OutputStream outputStream = response.getOutputStream()) {
    byte[] buffer = new byte[1024];
    int length;
    while ((length = urlStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, length);
    }
}