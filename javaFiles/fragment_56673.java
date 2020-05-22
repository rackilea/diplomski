ServerSocket serverSocket = null;
Socket workerSocket;
DataInputStream socketInputStream;
try {
    if (serverSocket == null) {
        // No need to get local IP address and to bind InetSocketAddress.
        // Following single line make it very simple.
        serverSocket = new ServerSocket(8222, 4);
        workerSocket = serverSocket.accept();
    }
    // When data are accepted socketInputStream will be invoked.
    socketInputStream = new DataInputStream(
                workerSocket.getInputStream());

    /* Since data are accepted as byte, all of them will be collected in the
    following byte array which initialised with accepted data length. */
    byte[] rvdMsgByte = new byte[socketInputStream.available()];

    // Collecting data into byte array
    for (int i = 0; i < rvdMsgByte.length; i++)
        rvdMsgByte[i] = socketInputStream.readByte();

    // Converting collected data in byte array into String.
    String rvdMsgTxt = new String(rvdMsgByte);

    // Setting String to the text view.
    receivedMsg.setText(rvdMsgTxt);
} catch (Exception ex) {
    throw ex;
}