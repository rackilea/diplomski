public class Client {
   private Runnable runnable;

   public void sendMessage(String message, Runnable runnable) {
      // Method to send messages to server
      this.runnable = runnable;
   }

   public void messageDelivered(String receivedMessage) {
      // This is a method subscribed successfull message delivering
      this.runnable.run();
   }
}