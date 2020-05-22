import java.awt.Toolkit;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class demo 
{
  Toolkit toolkit;
  Timer timer;
  public demo()
  {
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    timer.schedule(new scheduleDailyTask(), 0, //initial delay
        1 * 1000); //subsequent rate
  }
  class scheduleDailyTask extends TimerTask 
  {
    public void run() 
    {
      Date date = new Date();
      if(date.getHours()==5 && date.getMinutes()==0 && date.getSeconds()==0)
      {
          System.out.println("its 5 O clock");
          System.out.println("run the daily schedule method now");
      }
    }
  }
  public static void main(String args[]) {
    new demo();
  }
}