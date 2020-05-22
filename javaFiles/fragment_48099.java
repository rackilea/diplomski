import java.util.Timer;
import java.util.TimerTask;

public class Gettest {
    private static Timer timer;

    public static void main(String[] args) {
        ClassB b = new ClassB();
        ClassC c = new ClassC(b); // pass the B instance "b" into C
        timer = new Timer();
        timer.schedule(b, 0, 2000);
        Timer timer2 = new Timer();
        timer2.schedule(c, 0, 2000);
    }
}

class ClassB extends TimerTask {
    private int counter = 0;

    public int getint() {
        return counter;
    }

    public void setint(int Counter) {
        this.counter = Counter;
    }

    public void run() {
        counter++;
        this.setint(counter);
    }
}

class ClassC extends TimerTask {
    ClassB b;

    // add a constructor to allow passage of B into our class
    public ClassC(ClassB b) {
        this.b = b;  // set our field
    }

    public void run() {
        System.out.println(b.getint());
    }
}