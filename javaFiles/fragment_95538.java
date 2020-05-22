public class Server {
   static PizzaManager manager = new PizzaManager();
   private static void handleConnection(Socket client) throws IOException {
      ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
      ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

      ObjectToServer objectIn;
         try {
            objectIn = (ObjectToServer) ois.readObject();
            String buttonPressed = objectIn.getButtonPressed();

            if(buttonPressed.equals("NamenSuche")) {
               String searchedPizzaName = objectIn.getParameterList().get(0);
               manager.namenSuche(searchedPizzaName);

               ObjectToClient objectOut = new ObjectToClient();
               objectOut.setResults(manager.getResults());
               oos.writeObject(objectOut); // instead of objectIn
            }
            // some more cases..
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }

         ois.close();
         oos.close();
   }

   public static void main(String[] args) throws IOException {
      ServerSocket server = new ServerSocket(3141);
      while(true) {
         Socket client = null;
         try {
            client = server.accept();
            handleConnection(client);
         }
         catch(IOException e) {
            e.printStackTrace();
         }
         finally {
            if(client!=null) {
                try {
                    client.close();
                }
                catch(IOException e) {
                }
            }
        }
      }
   }
}