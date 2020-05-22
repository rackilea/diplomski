public class MyNewThread implements Runnable {

    private final Thread t;
    private volatile boolean shouldStop = false;

    MyNewThread() {
        t = new Thread (this, "Data Thread");
    }

    public void start() {
        t.start();
    }

    public void stop() {   
         shouldStop = true;
    }

    public void run()  {
         while(!shouldStop)
         {
             // do stuff
         }
    }
}