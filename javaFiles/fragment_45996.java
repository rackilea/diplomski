BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

    String msg = "its a test message";
    byte[] byteMsg = msg.getBytes();

    int length = byteMsg.length;
    byte[] lengthByte = ByteBuffer.allocate(4).putInt(length).array();

    byte[] finalMsg = new byte[length+4];
    System.arraycopy(lengthByte, 0, finalMsg, 0, 4);
    System.arraycopy(byteMsg, 0, finalMsg, 4, length);

    bufferedOutputStream.write(finalMsg);