ChannelExec channel= (ChannelExec) session.openChannel("exec");
channel.setCommand("ls /path/to/remote/dir");
InputStream in=channel.getInputStream();
channel.connect()
// read your ls-output from the input stream here
channel.disconnect()