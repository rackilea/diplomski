import java.util.*;

...

private void dieCaller() {
    TimerTask task = new TimerTask() {
        int numRolls = 0;

        @Override
        public void run() {
            if (numRolls < 9) {
                dice();
                numRolls++;
            }
            else {
                cancel();
            }
        }
    };

    Timer timer = new Timer("Die Roller");
    timer.scheduleAtFixedRate(task, 0, 200);
}

...