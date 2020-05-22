ServerSocket server=ServerSocket.open();
server.bind(new InetSocketAddress(1000));
SocketChannel clientChannel= server.accept();
File fileToSend=new File("stalkunderflow.txt").
String filename=fileToSend.getName();
byte[] nameBytes=filename.getBytes("UTF-8");
ByteBuffer nameBuffer=ByteBuffer.wrap(nameBytes);
clientChannel.write(nameBuffer);

//now  prepare and send file contents

FileChannel sbc=FileChannel.open(fileToSend.toPath());
             ByteBuffer buff=ByteBuffer.allocate(10000000);

             int bytesread=sbc.read(buff);

             while(bytesread != -1){
            buff.flip();
           clientChannel.write(buff);
            buff.compact();
            bytesread=sbc.read(buff);
             }