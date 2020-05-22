final DatagramPacket packet = new DatagramPacket(data, data.length);
while (running) {
    try {
        socket.receive(packet);
        ...
    final String messageToPrint = new String(
            packet.getData(), 
            packet.getOffset(), 
            packet.getLength());
    ...