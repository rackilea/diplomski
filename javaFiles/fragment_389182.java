private byte[] readNextPacket(DataInputStream stream) throws IOException{
    int bytesToRead = stream.readInt();
    byte[] data = new byte[bytesToRead];

    stream.readFully(data);
    return data;
}