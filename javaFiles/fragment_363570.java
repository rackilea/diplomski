import java.util.*;

TimerTask tt = new TimerTask() {
  public void run() {
    mine();
  }
}

Timer t = new Timer();
t.scheduleAtFixedRate(tt, 0, 1000);