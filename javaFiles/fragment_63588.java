private void createSingleWriteClient() throws IOException {
    Socket client = new Socket("localhost",22222);
    String text = "hello";
    // you can specify encoding of text to bytes by default java is UTF-8
    // encode length as 2 bytes (short integer) using big endian
    byte[] bytes = text.getBytes("UTF-16");
    byte[] message = new byte[2+bytes.length];
    message[0] = (byte)(bytes.length >> 8);
    message[1] = (byte)(bytes.length & 0x0ff);
    System.arraycopy(bytes, 0, message, 2, bytes.length);
    // write message to socket
    client.getOutputStream().write(message);
    client.getOutputStream().close();
    client.close();
    System.out.println("client closed");
}