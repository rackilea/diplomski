private void sendChunked( String msg, int chunkSizeInBytes ) {
   byte[] msgBytes = msg.getBytes();
   for( int index = 0; index < msgBytes.length ; index += chunkSizeInBytes ) {
         DatagramPacket packet = new DatagramPacket( msgBytes, index, Math.min( chunkSizeInBytes, msgBytes.length-index ));
         send( packet ); // You know how that works ...
   }
}