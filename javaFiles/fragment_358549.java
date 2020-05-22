InputStream in = new BufferedInputStream(client.retrieveFileStream(ftpFilePath), 16384);
// ...
byte[] buffer = new byte[8192];
long totalRead = 0;
for (int resumeTry = 0; resumeTry <= RESUME_TRIES; ++resumeTry) {
    try {
        while ((rd = in.read(buffer)) > 0) {
            //...
            totalRead += rd;
        }
        break;
    } catch (SocketTimeoutException ex) {
        // omitting exception handling
        in.close();
        client.abort();
        client.connect(...);
        client.login(...);
        client.setFileType(FTPClient.BINARY_FILE_TYPE);
        client.enterLocalPassiveMode();
        client.setRestartOffset(totalRead);
        in = client.retrieveFileStream(...);
        if (in == null) {
            // the FTP server doesn't support REST FTP query
            throw ex;
        }
        in = new BufferedInputStream(in, 16384);
    }
}