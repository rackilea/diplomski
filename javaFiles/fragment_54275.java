Socket socket = new Socket();
InetAddress addr = InetAddress.getByName(SERVER_IP);
SocketAddress sockaddr = new InetSocketAddress(addr, SERVER_PORT);
// 500ms is too short, up to you.
// normal time would be 5 to 20 seconds, depends on network (intranet/internet)
socket.connect(sockaddr, 500);
// 500ms to timeout reading from the socket
socket.setSoTimeout(500);