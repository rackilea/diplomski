public void FTPSUploader(String host, String user, String pwd,int numPort) throws Exception {
    FTPSClient ftp = new FTPSClient();
    ftps.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
    int reply;
    ftps.connect(host, numPort);
    reply = ftp.getReplyCode();
    if (!FTPReply.isPositiveCompletion(reply)) {
        ftps.disconnect();
        throw new Exception("Exception in connecting to FTPs Server");
    }
    ftps.login(user, pwd);
    ftps.setFileType(FTP.BINARY_FILE_TYPE);
    ftps.enterLocalPassiveMode();
    ftps.execPBSZ(0);// Set protection buffer size
    ftps.execPROT("P");// Set data channel protection to private--
}