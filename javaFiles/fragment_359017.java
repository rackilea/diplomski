final String MULTICAST_GROUP = "224.0.0.224";
final int PORT = 2244;
public String getMultiCast() {
    MulticastSocket socket = new MulticastSocket(PORT);
    InetAddress address = InetAddress.getByName(MULTICAST_GROUP);
    socket.joinGroup(address);
    DatagramPacket packet;
    byte[] buf = new byte[256];
    packet = new DatagramPacket(buf, buf.length);
    socket.receive(packet);
    String rtn = new String(packet.getData());
    socket.leaveGroup(address);
    socket.close();
    return rtn;
}