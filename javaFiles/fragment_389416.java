void run() {
    socket = new DatagramSocket(4445);

    while(true) {
         byte[] buf = new byte[256];
         DatagramPacket packet = new DatagramPacket(buf, buf.length);
         socket.receive(packet); //JVM will wait here, until there is an incoming packet
         onMessage(packet.getData())
    }
 } 

 public abstract void onMessage(final byte[] pkt);