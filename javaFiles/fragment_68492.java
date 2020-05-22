public void run() {
    try (DatagramSocket socket = new DatagramSocket(mHostPort)) { 

        // Get the socket to the receiving port
        DatagramSocket socket = new DatagramSocket(mHostPort);

        // Create receive-buffer and receive-packet
        byte[] receiveBuffer = new byte[MAX_BUFFER_SIZE];
        DatagramPacket datagramPacket = 
             new DatagramPacket(receiveBuffer,MAX_BUFFER_SIZE);

        // Pause thread here listening for packet
        socket.receive(datagramPacket);
        System.out.println("Datagram received successfully");
    }
    catch (IOException | RuntimeException e) {
        e.printStackTrace();
    }
}