ServerSocket sSock;
Socket cSock;

sSock = new ServerSocket(port_number);
clientSocket = sSock.accept();
System.out.println(cSock.getRemoteSocketAddress()+" connected\n");