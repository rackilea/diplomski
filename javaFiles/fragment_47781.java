while(true) {
    Socket sock = socket.accept();
    DataOutputStream outByte = new DataOutputStream(sock.getOutputStream());
    outByte.writeUTF("SOME_MESSAGE");
    outByte.writeLong(948L);
    outByte.flush();