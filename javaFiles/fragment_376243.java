// Java language
// Buffer for receiving incoming data
byte[] inboundDatagramBuffer = new byte[1024];
DatagramPacket inboundDatagram = new DatagramPacket(inboundDatagramBuffer, inboundDatagramBuffer.length);
// Source IP address
InetAddress sourceAddress = inboundDatagram.getAddress();
// Source port
int sourcePort = inboundDatagram.getPort();
// Actually receive the datagram
socket.receive(inboundDatagram);