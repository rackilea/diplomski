Session sessionRead = jsch.getSession("username", "127.0.0.1", 22);
sessionRead.connect();

Session sessionWrite = jsch.getSession("username", "127.0.0.1", 22);
sessionWrite.connect();

ChannelSftp channelRead = (ChannelSftp)sessionRead.openChannel("sftp");
channelRead.connect();

ChannelSftp channelWrite = (ChannelSftp)sessionWrite.openChannel("sftp");
channelWrite.connect();

PipedInputStream pin = new PipedInputStream(2048);
PipedOutputStream pout = new PipedOutputStream(pin);

channelRead.get("/path/to/your/file/including/filename.txt", pout);
channelWrite.put(pin, "/path/to/your/file/destination/including/filename.txt");

channelRead.disconnect();
channelWrite.disconnect();

sessionRead.disconnect();
sessionWrite.disconnect();