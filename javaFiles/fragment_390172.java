ServerSocket myServerSocket = new ServerSocket(9999);
while (true) {
    Socket skt = myServerSocket.accept();
    Handling obj = new Handling();
    obj.handle(skt);
}