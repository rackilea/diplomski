public static void main(String[] args) {
    putFile("user", "host", "passwd", "/../test.txt", "C:/test.txt");
}
public static void putFile(String username, String host, String password, String remotefile,     String localfile){
    JSch jsch = new JSch();
    Session session = null;
    try {
          session = jsch.getSession(username, host, 22);
          session.setConfig("StrictHostKeyChecking", "no");
          session.setPassword(password);
          session.connect();

          Channel channel = session.openChannel("sftp");
          channel.connect();
          ChannelSftp sftpChannel = (ChannelSftp) channel;
          sftpChannel.put(localfile, remotefile);
          sftpChannel.exit();
          session.disconnect();
     } catch (JSchException e) {
          e.printStackTrace();  
     } catch (SftpException e) {
          e.printStackTrace();
     }
}