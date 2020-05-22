public byte[] readPacket( DataInputStream dataIn ) throws IOException {
    int length = dataIn.readInt();
    byte[] packet = new byte[ length ];
    dataIn.readFully( packet );
    return packet;
}

public void writePacket( DataOutputStream dataOut, byte[] packet ) throws IOException {
    dataOut.writeInt( packet.length );
    dataOut.write( packet );
}