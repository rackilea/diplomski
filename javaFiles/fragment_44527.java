public class ThreadTest4 extends Thread {
    static Object lock = new Object[0];
    private MyWork4 myWork = new MyWork4();

    public static void main(String[] args) {
        ThreadTest4 thread1 = new ThreadTest4();
        ThreadTest4 thread2 = new ThreadTest4();
        ThreadTest4 thread3 = new ThreadTest4();
        ThreadTest4 thread4 = new ThreadTest4();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public void run() {
        synchronized(lock){
            myWork.setA();
            System.out.println(myWork.getA());   
        }
    }
}

class MyWork4 {

    @GuardedBy("lock")
    private static int a;

    public synchronized int getA() {
        return a;
    }

    public synchronized void setA() {
        a++;
    }

}