protected void connect() throws FTPException {
    int reply;

    // Connect to the FTP server
    try {
        ftpClient.connect(hostName);
    } catch (IOException e) {
        throw new FTPException(e, "unable to connect to: "+hostname);
    }
    ...
}