while(true) {
   // Create the Datagram   
   DatagramPacket outToServer = new DatagramPacket(data, data.length, serverAddress, port);
   // Create socket to send
   DatagramSocket socket = new DatagramSocket();
   // send datagram through the socket
   socket.send(outToServer);
}