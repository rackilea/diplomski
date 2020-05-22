// Use passive mode as default because most of us are
    // behind firewalls these days.
    ftps.enterLocalPassiveMode();
    ...
    String remote = "samFromClient.txt"; //Place on FTP
    String input = "D:/sam.txt"          //Place on your Client
    //Your FTP reads from the inputstream and store the file on remote-path
    InputStream input = new InputStream(new FileInputStream(input));
    ftps.storeFile(remote, input);
    input.close();
    ftps.logout();
    ...