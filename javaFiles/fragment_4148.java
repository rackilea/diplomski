BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 String line = null;
 while( (line = br.readLine() ) != null) {
   System.out.println("Message from server: " + br.readLine());
   EventQueue.invokeLater(new Runnable() {
     public void run() {
      model.addElement(line);
   }