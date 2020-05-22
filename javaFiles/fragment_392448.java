public class VariableRemover implements Runnable {
   private long expiryTime = 10*60*1000; // convert minutes to millis
   public void run(){
       if(! photo_sent && System.currentTimeMillis() > (timeWhenThisObjectWasBuilt + expiryTime)){
          answer= null;
       }

   }

}