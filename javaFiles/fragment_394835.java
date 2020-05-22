import java.util.Timer;
import java.util.TimerTask;

public class Foo {
    public static void scheduleTimer() {
        Timer timer = new Timer();
        long c = 3000;
        timer.scheduleAtFixedRate(new MyTimerTask(), c, c);
    }

    public static int getNum() { return x++; }
    private static int x = 0;
    public static void resetNum() { x = 0; }
}

class MyTimerTask extends TimerTask {
    public void run() {
        Foo.resetNum();
    }
}

class Bar {
    public static void main(String[] args) throws Exception {
        Foo.scheduleTimer();
        while (true) {
            System.out.println(Foo.getNum());
            Thread.sleep(1000);
        }
    }
}