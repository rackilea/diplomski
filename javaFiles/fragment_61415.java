DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

try {
   while(true) {
       listener.startOfMessage();
       for(int segSize; (segSize = dis.readInt()) > 0;) {
          byte[] bytes = new byte[segSize];
          dis.readFully(bytes);
          listener.data(bytes);
       }
       int footer = dis.read();
       // check footer ??
       listener.endOfMessage();
   }
} catch(EOFException endOfStream) {
   // handle or ignore
} finally {
   // close everything.
}