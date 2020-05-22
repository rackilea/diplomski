/** Server class constructor */
public Server(BlockingQueue<GameEvent> queue) {
  eventQueue = queue;
  try {
    serverSocket = new ServerSocket(Constants.PORT_NUMBER);
    socket = serverSocket.accept();  
    inputStream = socket.getInputStream();  
    objectStream = new ObjectInputStream(inputStream);  
  } catch(IOException e) {
    e.printStackTrace();
  }  
  Thread thread = new Thread(this);
  thread.start();
}