public void packetCompose(String user, String password) {
    try {
        byte[] userBytes = user.getBytes();
        byte[] passwordBytes = password.getBytes();
        byte[] buf = new byte[256];
        //first byte contain user length in bytes
        System.arraycopy( new byte[]{(byte)userBytes.length}    , 0, buf, 0, 1 );
        // Then the user
        System.arraycopy( userBytes    , 0, buf,   1, userBytes.length );
        //a byte containing password length in bytes after user
        System.arraycopy( new byte[]{(byte)passwordBytes.length} ,0 , buf,   userBytes.length +1, 1);
        // password
        System.arraycopy( passwordBytes , 0, buf,   userBytes.length+2, passwordBytes.length );

        DatagramPacket packet = new DatagramPacket(buf, 256, serverAddress, 4445);
        socket.send(packet);
    } catch (SocketException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
}