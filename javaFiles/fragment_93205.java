DataInputStream din = new DataInputStream(mmInStream);

while (bluetoothConnected) {
    try {
        // Read packet header
        int commandType = swap(din.readShort());
        int payloadSize = swap(din.readShort());
        int packetSize = PACKET_HEADER_SIZE + payloadSize;
        byte[] packet = new byte[packetSize];
        din.readFully(packet);
        parsePacketSequence(socket, packet);
    } 
    catch (IOException e) {
        bluetoothConnected = false;
        Log.d(TAG, "Error " + e);
        break;
    }
}