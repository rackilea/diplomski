private void readInternalPacket() {
    System.out.println("readInternalPacket");
    try {
        int packetSize = dataIN.readInt();
        packet = new byte[packetSize];
        dataIN.read(packet, 0, packetSize);
        dataPacketSize = packetSize;
    } catch (Exception e) {
        e.printStackTrace();
    }
}