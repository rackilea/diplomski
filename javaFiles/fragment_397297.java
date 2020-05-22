public void run(){

  try {
     DataInputStream dis = new DataInputStream(socket.getInputStream());
     receiveData = dis.readLine();
     System.out.println("client Message: " + receiveData);
   } catch (IOException e) {
     // handling of the exception : logging and probably end of execution of 
        the current thread
    }
}