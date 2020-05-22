public Connect(Socket clientSocket) {
 client = clientSocket;
 try {
  ois = new ObjectInputStream(client.getInputStream());
  oos = new ObjectOutputStream(client.getOutputStream());
 } catch(Exception e1) {
     // ...
 }
 this.start();
}