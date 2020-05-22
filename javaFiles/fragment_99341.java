//this is a test enviroment,therefore my server is running on the same machine as the client. 
SocketAddress address=new InetSocketAddress(InetAddress.getLocalHost(),1000);
 SocketChannel clientChannel=SocketChannel.open(address);

 ByteBuffer namebuff=ByteBuffer.allocate(500);
 clientChannel.read(namebuff);

byte[] namebyte=new byte[500];
String filename="";

int position=namebuff.position();

 while(namebuff.hasRemaining()){
    namebyte[position]=namebuff.get();
    position=namebuff.position();
 }
 filename=new String(namebyte,0,position);

 File file=new File(filename);

 ByteBuffer bb=ByteBuffer.allocate(10000000);
 int bytesRead=clientChannel.read(bb);
 FileOutputStream bout =new FileOutputStream(file);
  FileChannel sbc=bout.getChannel();

 while(bytesRead != -1){
   bb.flip();
   sbc.write(bb);
   bb.compact();
  bytesRead=clientChannel.read(bb);
 }