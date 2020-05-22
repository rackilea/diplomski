import java.util.TimerTask;
import java.util.Timer;

public class TimerSchedule {

    public Timer timer = new Timer();

    public void TestTimerSchedule() {
        System.out.println("Before timer.schedule");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask");
            }
        }, 2000);

        System.out.println("After timer.schedule");
    }

}