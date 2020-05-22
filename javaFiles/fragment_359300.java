private byte[] readTillTimeout(DataInputStream in) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
    try
    {
        int input = in.read();
        if (input == -1) throw new IllegalStateException("disconnected");
        baos.write((byte)input);
    }
    catch (SocketTimeoutException ste)
    {
    }
    return baos.toByteArray();
}