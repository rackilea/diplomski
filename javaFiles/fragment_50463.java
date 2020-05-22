public static void upload(File file, boolean retry) {
    try 
    {
        System.out.println("Uplodaing file " + file.getName());

        JSch jsch = new JSch();
        Session session = jsch.getSession(USER, HOST, PORT);
        session.setPassword(PASSWORD);

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect();

        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;

        if (!retry)
            sftpChannel.put(file.getAbsolutePath(), file.getName(), ChannelSftp.OVERWRITE);
        else
            sftpChannel.put(file.getAbsolutePath(), file.getName(), ChannelSftp.RESUME);

        channel.disconnect();
        session.disconnect();
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
        upload(file, true);
    }

}