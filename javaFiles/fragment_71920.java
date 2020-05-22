DatagramChannel channel = DatagramChannel.open();
channel.socket().bind(new InetSocketAddress(9999));

ByteBuffer chunkData = ByteBuffer.allocate(1024);
chunkData.clear();

channel.receive(chunkData);

// remove unwanted data
byte[] validData = new byte[chunkData.position()];
System.arraycopy(chunkData.array(), 0, validData, 0, validData.length);

System.out.println("---has received data:" + new String(validData));