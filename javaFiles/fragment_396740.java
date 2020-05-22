public class MyRunnable implements Runnable {
     public Thread myThread;
     public void run() {
         myThread = Thread.currentThread();
         ...
     }
     public void interruptMe() {
         myThread.interrupt();
     }
}