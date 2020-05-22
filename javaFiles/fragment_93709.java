while (true) {
    Socket connection = serverSocket.accept();
    new Therad() {
         public void run() {
              serveConnection(connection);
         }
    }.start();
}