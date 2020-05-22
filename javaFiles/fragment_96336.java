ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
channel.connect();

for (Object entry : channel.ls("/srv")) {
    System.out.println(entry);
}