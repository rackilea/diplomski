ServerSocket serverSocket = new ServerSocket(8080);
while(!serverSocket.isClosed()) {
    Socket socket = serverSocket.accept();
    System.out.println("Accepted socket "+socket);
    BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
    StringBuilder sb = new StringBuilder();
    int b;
    while((b = bis.read())>=0) {
        if (b == '\r')
            b = bis.read();
        if (b == '\n') {
            System.out.println(sb);
            sb.setLength(0);
        } else {
            sb.append((char) b);
        }
    }
    System.out.println("Closing socket.");
    socket.close();
}