import com.jcraft.jsch.Channel;
            import com.jcraft.jsch.ChannelSftp;
            import com.jcraft.jsch.JSch;
            import com.jcraft.jsch.JSchException;
            import com.jcraft.jsch.Session;
            import com.jcraft.jsch.SftpException;

            public class FileTransfer {
                public static void main(String args[]) {
                    String hostname = "";
                    String username = "";
                    String password = "";
                    String copyFrom = "";
                    String copyTo = ""; 
                    JSch jsch = new JSch();
                    Session session = null;
                    System.out.println("Trying to connect.....");
                    try {
                        session = jsch.getSession(username, hostname, 22);
                        session.setConfig("StrictHostKeyChecking", "no");
                        session.setPassword(password);
                        session.connect(); 
                        Channel channel = session.openChannel("sftp");
                        channel.connect();
                        ChannelSftp sftpChannel = (ChannelSftp) channel; 
                        sftpChannel.get(copyFrom, copyTo);

                        sftpChannel.exit();
                        session.disconnect();
                        System.out.println("Done !!");
                    } catch (JSchException e) {
                        e.printStackTrace();  
                    } catch (SftpException e) {
                        e.printStackTrace();
                    }

                }
            }