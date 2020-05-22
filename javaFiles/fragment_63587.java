private void createClient() throws IOException {
    Socket client = new Socket("server",22222);
    String text = "hello"
    // you can specify encoding of text to bytes by default java is UTF-8
    byte[] message = text.getBytes("ASCII"); 
    // encode length as 2 bytes (short integer) using big endian
    byte[] length = new byte[2];
    length[0] = (byte)(message.length >> 8);
    length[1] = (byte)(message.length & 0x0ff);
    // write message length to socket
    client.getOutputStream().write(length);
    // write message to socket
    client.getOutputStream().write(message);
    client.getOutputStream().close();
    client.close();
    System.out.println("client closed");
}