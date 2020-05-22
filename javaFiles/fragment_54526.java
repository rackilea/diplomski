ftp.connect(server);

// After connection attempt, you should check the reply code to verify success.
reply = ftp.getReplyCode();

if (!FTPReply.isPositiveCompletion(reply))
{
    ftp.disconnect();
    System.err.println("FTP server refused connection.");
    System.exit(1);
}

// read the initial response (aka "Welcome message")
String[] welcomeMessage = ftp.getReplyStrings();