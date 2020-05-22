import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Chronometer extends Observable {

    private Timer timer = new Timer();
    private final int startTime = 30000;
    private int time = 30000;

    public void decreaseTime() {
        if (time > 0) time--;
    }

    public int getTime() {
        return time;
    }

    public void reset() {
        time = startTime;
    }

    public void startCountDown(int delay) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                decreaseTime();
                setChanged();
                notifyObservers();
            }
        }, delay,1);
    }
}