class Test {
    private int x  = 0;

    public void incX() {
        synchronized(this) {
            x = ++x;                         // See "Side Note" below
        }
        System.out.println("x is: "+x+"     "+Thread.currentThread().getName());
    }
}
public class Main {
    public static void main(String[] args) {
        Test test = new Test();              // One instance
        Thread t1 = new Thread(() -> {
            test.incX();                     // Used by this thread
        });
        Thread t2 = new Thread(() -> {
            test.incX();                     // And also by this one
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (Exception e) {
        }
        System.out.println("Done");
    }
}