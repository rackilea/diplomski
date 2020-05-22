public ConnectionHandler(server server, Socket socket) {
    this.server = server;
    this.socket = socket;
    this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    this.out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
}