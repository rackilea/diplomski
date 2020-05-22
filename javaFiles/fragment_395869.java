InputStream inputStream = ftpClient.retrieveFileStream(remoteFile1);
int returnCode = ftpClient.getReplyCode();
if (inputStream == null || returnCode == 550) {
    System.out.println("Remote file does not exist");
} else {
    ftpClient.completePendingCommand();
    byte[] buffer = new byte[inputStream.available()];
    inputStream.read(buffer);
    OutputStream outputStream = new FileOutputStream(downloadFile1);
    outputStream.write(buffer);
    outputStream.close();
}