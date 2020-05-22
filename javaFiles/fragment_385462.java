InetAddress addr = InetAddress.getByName(serverIP);
SocketAddress socketAddress = new InetSocketAddress(addr, serverPort);

//here follows the old client code
SocketAddress socketAddress = new InetSocketAddress(serverHostName, serverPort);
client = new Socket();
client.bind(null);
client.connect(socketAddress, SOCKET_TIMEOUT); //exception happens in this method
connected = true;