public class ClientHandler implements Runnable {

   private final Socket socket;

   public ClientHandler(Socket socket) {
     this.socket = socket;
   }

    public void run() {
       try (Socket socket = this.socket;
            Scanner in = new Scanner(socket.getInputStream();
            PrintWriter out = new PrintWriter(socket.getOutputStream()) {

               //todo: do whatever you need to do


       } catch (IOException ex) {
           ex.printStackTrace();
       }

       System.out.println("Client disconnected.");
    }  
}