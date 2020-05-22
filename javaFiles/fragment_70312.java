// Server side
    final DataInputStream InFromClient = new DataInputStream(soc_1.getInputStream());
    final DataOutputStream OutToClient = new DataOutputStream(soc_1.getOutputStream());
    // than use OutToClient.writeInt() and InFromClient.readInt()

    // Client side
    final DataInputStream FromServer = new DataInputStream(Server_info.getInputStream());
    final DataOutputStream ToServer = new DataOutputStream(Server_info.getOutputStream());
    // than use ToServer.writeInt() and FromServer.readInt()