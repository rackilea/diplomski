public byte[] readBytes() throws IOException {
    // Again, probably better to store these objects references in the support class
    InputStream in = socket.getInputStream();
    DataInputStream dis = new DataInputStream(in);

    int len = dis.readInt();
    byte[] data = new byte[len];
    if (len > 0) {
        dis.readFully(data);
    }
    return data;
}