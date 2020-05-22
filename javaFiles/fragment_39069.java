ftp = new FTPClient();
    ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
    int reply;
    ftp.connect(host,numPort); //if you have not port number, use only host
    reply = ftp.getReplyCode();
    if (!FTPReply.isPositiveCompletion(reply)) {
        ftp.disconnect();
        System.out.println("Error");
    }
    ftp.login(user, pwd);
    ftp.setFileType(ftp.BINARY_FILE_TYPE);
    ftp.enterLocalPassiveMode();
    ftp.printWorkingDirectory(); //print workingdirectory
    ftp.changeWorkingDirectory("/work"); //change directory
    ftp.printWorkingDirectory();
    FTPFile[] files1 = ftp.listFiles();
    for (FTPFile file : files) {
        String details = file.getName();
        Calendar dateOfmyFile=file.getTimestamp();
        boolean isaDir=false;
        if (file.isDirectory()) {
            details = "[" + details + "]";
            isaDir=true;
        }
        else{
           downloadFile(host+details, mylocalFilePath);
          }
       }
public void downloadFile(String remoteFilePath, String localFilePath) throws IOException {
    FileOutputStream fos = null;
    ftp.printWorkingDirectory();
    try {
        fos =new FileOutputStream(localFilePath);
        ftp.retrieveFile(remoteFilePath,fos);
        fos.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}