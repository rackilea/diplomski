import java.util.Timer;
import java.util.TimerTask;

public class Greeter {
   private static class SayHello extends TimerTask {
      @Override
      public void run() {
         System.out.println("Hello");
      }
   }
   public static void main(String[] args) throws InterruptedException {
      Timer t = new Timer();
      int delay = 0;
      int period = 1000; // milliseconds
      t.scheduleAtFixedRate(new SayHello(), delay, period);

      Thread.sleep(5000); // Do something

      t.cancel();
   }
}