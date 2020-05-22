public class ParentClass {

   protected boolean checkConnection() {
      Client client = new Client(); // Lets skip all configuration and connection details
      String testMessage = "Test message";
      // Check that messageDelivered() was called in client with testMessage parameter
      MyRunnable runnable = new MyRunnable();
      client.sendMessage(testMessage, runnable);

      try {
         runnable.wait( 10000 );  // Wait for 10 seconds
      } catch( InterruptedException e ) {
         e.printStackTrace();
      }

      return runnable.getResult();
   }
}