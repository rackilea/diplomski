import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Timer;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;

@Stateless
public class RetryWithWaitBean {


   @Resource
   private SessionContext context;

    /**
    *Create a timer that will be activated after the duration passes.
    */
   public void doActionAfterDuration(long durationMillis) {
      final TimerConfig timerConfig= new TimerConfig()
      timerConfig.setPersistent(false);
      context.getTimerService()..createSingleActionTimer(durationMillis,timerConfig);
   }

   /** Automatically executed by server on timer expiration.
   */
   @Timeout
   public void timeout(Timer timer) {
      System.out.println("Trying after timeout. Timer: " + timer.getInfo()); 
      //Do custom action 
      doAction();

      timer.cancel();
   }

   /**
    * Doing the required action 
    */
   private void doAction(){
      //add your logic here. This code will run after your timer.
    System.out.println("Action DONE!"); 
  }
}