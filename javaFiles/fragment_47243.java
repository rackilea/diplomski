InputStream inputStream = ftpClient.retrieveFileStream(totalFilePath);

BufferedImage bimg = ImageIO.read(inputStream);

inputStream.close();
if (!ftpClient.completePendingCommand()) {
    // Throw some error or do something, file transfer failed
}