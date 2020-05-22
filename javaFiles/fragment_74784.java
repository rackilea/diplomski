ServerSocket ss = new ServerSocket(... params ...);
while(isRunning) {
    Socket socket = ss.accept();
    Runnable r = new SocketHandler(socket); // write the socket handler class
    Thread t = new Thread(r);
    t.start();
}