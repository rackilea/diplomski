public class YourHttpSessionListener implements HttpSessionListener {       
   public void sessionCreated(HttpSessionEvent event) {
   //put row in the database
   }

   public void sessionDestroyed(HttpSessionEvent event) {
     //delete the row from database     
   }
}