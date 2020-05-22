public class MyRunnable implements Runnable {

    private int var;

    public MyRunnable(int var) {
        this.var = var;
    }

    public void run() {
        // code in the other thread, can reference "var" variable
    }
}

public class MainThreadClass {
    public static void main(String args[]) {
        MyRunnable myRunnable = new MyRunnable(10);
        Thread t = new Thread(myRunnable)
        t.start();
    }    
}