public class2(Socket socket) {
   try {
      this.socket = socket;
      in = new BufferedInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      MyList.add(this);
   }
   catch (IOException ex) 
   {
       Logger.getLogger(ListenerServerThread.class.getName()).log(Level.SEVERE, null, ex);
   }
}