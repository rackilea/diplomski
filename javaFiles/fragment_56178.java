private InetAddress getOutboundAddress(SocketAddress remoteAddress) throws SocketException {
        DatagramSocket sock = new DatagramSocket();
        // connect is needed to bind the socket and retrieve the local address
        // later (it would return 0.0.0.0 otherwise)
        sock.connect(remoteAddress);

        final InetAddress localAddress = sock.getLocalAddress();

        sock.disconnect();
        sock.close();
        sock = null;

        return localAddress;
    }

//DatagramPacket receivePacket;
socket.receive(receivePacket);
System.out.print("Local IP of this packet was: " + getOutboundAddress(receivePacket.getSocketAddress()).getHostAddress);