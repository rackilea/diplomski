final Socket connectionSocket = new Socket("...", 8888); // To be changed
BufferedReader inFromSender = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
Thread t = new Thread() {
   public void run() {
      try {
          Thread.sleep(2000); // Wait 2 s
          connectionSocket.close();
          System.out.println("Data Transmission failed");
      } catch(InterruptedException e) {
         // Handle exception
      }
   }
};
t.start();
while((clientSentence = inFromSender.readLine()) != null) {
   System.out.println("Received: " + clientSentence);
}