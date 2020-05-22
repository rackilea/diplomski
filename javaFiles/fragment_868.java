NetworkInterface ni = NetworkInterface.getByInetAddress(address);
InetAddress group = InetAddress.getByName("239.255.0.1")

DatagramChannel dc = DatagramChannel.open(StandardProtocolFamily.INET)
    .setOption(StandardSocketOptions.SO_REUSEADDR, true)
    .bind(new InetSocketAddress(5000))
    .setOption(StandardSocketOptions.IP_MULTICAST_IF, ni);
MembershipKey key = dc.join(group, ni);

ByteBuffer byteBuffer = ByteBuffer.allocate(1500);
while (true) {
    if (key.isValid()) {
        byteBuffer.clear();
        InetSocketAddress sa = (InetSocketAddress) dc.receive(byteBuffer);
        byteBuffer.flip();

        System.out.println("Multicast received from " + sa.getHostString());

        // TODO: Parse message
    }
}