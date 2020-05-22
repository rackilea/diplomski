public class MainThread {

    public static void main (String[] args) throws InterruptedException{
        Thread.currentThread().setName("Main Thread");
        Object monitor = new Object();

        X x = new X(monitor);
        x.start();

        OtherThread y = new OtherThread(x);
        y.start();


        synchronized (monitor){
            System.out.println(Thread.currentThread().getName()+" Waiting");
            monitor.wait();
        }
        System.out.println(Thread.currentThread().getName()+": Now I'm running");

    }

}

class X extends Thread{

    private Object monitor;

    public X(Object monitor) {
      this.monitor = monitor;
    }

    public void run(){
        // setting thread name
        Thread.currentThread().setName("X");


        try {
            Thread.sleep(1000*5); // 5 seconds here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this.monitor){
            this.monitor.notify();// I want only notify/notifyAll inside X to be possible
            System.out.println("Notified from "+Thread.currentThread().getName()+" Thread");
        }

    }
}

class OtherThread extends Thread{
    Thread t;

    public OtherThread(Thread x){ // pass the X thread to this thread
        this.t = x;
    }

    public void run(){
        // setting thread name
        Thread.currentThread().setName("OtherThread");

        try {
            Thread.sleep(1000*1); // 1 second here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (t){
            t.notify(); // this will work, but it wont do anything.
            System.out.println("Notified from "+Thread.currentThread().getName()+" Thread");
        }
    }

}