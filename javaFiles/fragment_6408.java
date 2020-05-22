private void init() {
  new Thread(new SocketRunner()).start();
}

private class SocketRunner implements Runnabled {
    public void run() {
      try {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        scanner = new Scanner(socket.getInputStream());
        stream = new PrintStream(socket.getOutputStream());
        succes = true;
      } catch (Exception e) {
        succes = false;
        e.printStackTrace();
      }
    }
}