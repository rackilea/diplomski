DatagramSocket socket = null;
for (int port : Configuration.getPortList()) {
    try {
        socket = new DatagramSocket(port);
        break;
    } catch (SocketException ignored) {
        continue;
    }
}
if (socket == null) {
    socket = new DatagramSocket(0); 
}
this.socket = socket;