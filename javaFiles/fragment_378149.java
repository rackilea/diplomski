ServerSocket serverSocket = new ServerSocket(portNumber);
while(true){
  try{
    Socket clientSocket = serverSocket.accept();
    Thread thread = new ClientWorker(clientSocket);
    thread.start(); //start thread
  }catch(Exception err){
     err.printStackTrace();
  }
}