public static void sftpConnection() {

    // Object Declaration.
    JSch jsch = new JSch();
    Session session = null;
    Channel channel = null;

    // Variable Declaration.
    String user = "foo";
    String host = "10.9.8.7";
    Integer port = 22;
    String password = "test123";
    String watchFolder = "\\localhost\textfiles";
    String outputDir = "/remote/textFolder/";
    String filemask = "*.txt";


   try {
        session = jsch.getSession(user, host, port);

        /*
         * StrictHostKeyChecking Indicates what to do if the server's host 
         * key changed or the server is unknown. One of yes (refuse connection), 
         * ask (ask the user whether to add/change the key) and no 
         * (always insert the new key).
         */
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword(password);

        session.connect();

        channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp)channel;

        // Go through watch folder looking for files.
        File[] files = findFile(watchFolder, filemask);
        for(File file : files) {
            // Upload file.
            putFile(file, sftpChannel, outputDir);            
        }                 
    } finally {
        sftpChannel.exit();
        session.disconnect();
    }
}

public static void putFile(File file, ChannelSftp sftpChannel, String outputDir) {

    FileInputStream fis = null;

    try {
        // Change to output directory.
        sftpChannel.cd(outputDir);

        // Upload file.

        fis = new FileInputStream(file);
        sftpChannel.put(fis, file.getName());
        fis.close();

    } catch{}
}

public static File[] findFile(String dirName, final String mask) {
    File dir = new File(dirName);

    return dir.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String filename)
            { return filename.endsWith(mask); }
    } );
}