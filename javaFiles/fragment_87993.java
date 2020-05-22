public class StackOverFlowDemo {

/**
 * one
 * */
public static class MyRun implements Runnable {
    private int numtimes;

    public MyRun(int numtimes) {
        this.numtimes = numtimes;
    }

    @Override
    public void run() {
        for (int i = 0; i < numtimes; i++) {
            System.out.println(String.format("Thread(%s) Running... numtimes(%d), current count (%d) ",
                    Thread.currentThread().getName(),
                    numtimes, i));
        }
    }
}

/**
 * another way
 * */
public static void print(int numtimes) {
    for (int i = 0; i < numtimes; i++) {
        System.out.println(String.format("Thread(%s) Running... numtimes(%d), current count (%d) ",
                Thread.currentThread().getName(),
                numtimes, i));
    }
}

public static void main(String[] args) {
    /**
     * one
     * */
    Thread t1 = new Thread(new MyRun(150), "thread 1");
    Thread t2 = new Thread(new MyRun(200), "thread 2");
    t1.start();
    t2.start();

    /**
     * another way
     * */
    new Thread(() -> StackOverFlowDemo.print(150), "t1").start();
    new Thread(() -> StackOverFlowDemo.print(200), "t2").start();
}