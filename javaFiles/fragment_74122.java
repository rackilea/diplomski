import java.util.*;
import java.text.*;

public class ScheduleTask {

   private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   private static Timer timer = new Timer();

   private static class MyTimeTask extends TimerTask {
      public void run() {
         System.out.println("HOHO date just changed");
      }
   }

   public static void main(String[] args) throws ParseException {

      System.out.println("Current Time: " + df.format( new Date()));

      //Date and time at which you want to execute
      Date date = df.parse("2015-01-08 00:00:00");

      timer.schedule(new MyTimeTask(), date);
   }
}