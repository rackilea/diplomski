private byte[] readMessage(DataInputStream in, byte startByte, byte stopByte) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
    try
    {
        for(;;)
        {
            int input = in.read();
            if (input == -1) throw new IllegalStateException("disconnected");
            if (input == startByte) break;
        }

        for(;;)
        {
            int input = in.read();
            if (input == -1) throw new IllegalStateException("disconnected");
            if (input == stopByte) break;
            baos.write((byte)input);
        }
    }
    catch (SocketTimeoutException ste)
    {
      return null;
    }
    return baos.toByteArray();
}