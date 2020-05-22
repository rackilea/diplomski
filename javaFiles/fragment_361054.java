public class SocketImpl extends Thread
{
   private SocketObserver observer;

   public void setObserver(SocketObserver observer) {
         this.observer = observer;
   }

   // It is expected that the other program is ready
   public void run()
   {
      // receive some msg
      // if it's ready message
      observer.MessageReceived(yourMessageHere); //Notify the observer that a message is received
   }
}