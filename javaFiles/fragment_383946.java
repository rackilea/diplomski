public class TCPServer implements Runnable {
   private final int listeningPort;
   PrintWriter out;
   BufferedReader in;
   ServerSocket serverSocket;
   private final ExecutorService pool;

   public TCPServer(int port, int poolSize) {
       listeningPort = port;
       pool = Executors.newFixedThreadPool(poolSize);
   }    

   @Override
   public void run() {
       try {
           serverSocket = new ServerSocket(listeningPort);

           while (!Thread.currentThread().isInterrupted()) {    
               Socket clientSocket = serverSocket.accept();
               pool.submit(new ConnectionHandler(clientSocket)); 
           }

       } catch (IOException ex) {
           Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pool.shutdown();
       }
   }

   private class ConnectionHandler implements Runnable {
        private Socket sock;

       public ConnectionHandler(Socket sock){
           this.sock = sock;
       }

       @Override
       public void run() {
           while (!Thread.currentThread().isInterrupted()) {
               try{
                   in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                   String line = in.readLine();
                   System.out.println("Incoming: " + line);

                   sock.close();

                  } catch (IOException ex) { 
                      Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
                  }   
              }
          }
      }

   public void close(){        
       try {
           serverSocket.close();
       } catch (IOException ex) {
           Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}