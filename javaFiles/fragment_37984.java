import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test { 
   public static void main(String[] args) {

      //overcome limitation of closure not being able to modify outer variable with arr.
      final int[] runningThreads = {0};
      final int[] taskcount = {10};

      final Lock _mutex = new ReentrantLock(true);

      int maxThreadQty = 3;


      while ((taskcount[0] > 0) && (runningThreads[0] < maxThreadQty))  {
         System.out.println("New Thread Started");
         _mutex.lock();
         runningThreads[0]++;
         System.out.println("Running Threads: " + runningThreads[0]);
         System.out.println("Times to go: " + taskcount[0]);
         _mutex.unlock();
         new Thread("T") {
             public void run() {
                  // actually do something;
                  _mutex.lock();
                  taskcount[0]--;
                  runningThreads[0]--;
                  _mutex.unlock();
             }

          }.start();
      }
   }
}