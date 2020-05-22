ServerSocket Server = new ServerSocket(9999);

while(true) {
   try {
       Socket mySocket = Server.accept();
       DataInputStream input_stream = new DataInputStream(mySocket.getInputStream());
       String message  = input_stream.readUTF();

       someMethod();           //This method can generate an exception, then the application closes and I can not receive new requests
       text.append("\n" + message);
       mySocket.close();
   } catch (IOException ex) {
        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
   }
}