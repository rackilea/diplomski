while(true) {
    Socket socket = Ssocket.accept();
    [YourSocketClass] connection = new [YourSocketClass](socket);
    Thread thread = new Thread(connection);
    thread.start();
}