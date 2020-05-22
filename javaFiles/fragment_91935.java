channel.setCommand(command);

PipedOutputStream pos=new PipedOutputStream();
PipedInputStream pis=new PipedInputStream(pos);
channel.setOutputStream(pos);
channel.setExtOutputStream(pos);
InputStream in=pis;

channel.connect();