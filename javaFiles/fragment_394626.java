import java.util.Timer;
import java.util.TimerTask;

class Timer2 {

   private static final String[] ARRAY_ELEMENTS = {"value1", "value2", "value3", "value4"};

   public static void main(String[] args) {
      final Timer utilTimer = new Timer();
      utilTimer.scheduleAtFixedRate(new TimerTask() {
         private int index = 0;

         public void run() {
            System.out.println(ARRAY_ELEMENTS[index]);
            index++;
            if (index >= ARRAY_ELEMENTS.length) {
               utilTimer.cancel();
            }
         }
      }, 5000L, 5000L);
   }

}