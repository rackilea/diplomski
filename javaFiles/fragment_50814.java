public void Show() throws IOException {
    ServerSocket ss = new ServerSocket(6666);
    new IPScanning().dispose();
    int count = 0;
    while (true) {
        Socket s = null;
        try {
            s = ss.accept();  
            SocketThread socketThread = new SocketThread(s, count);
            socketThread.start();
        } catch (Exception e) {
            ss.close();
            s.close();
            System.out.println(e);
        } finally {
            count++;
        }
    }
}