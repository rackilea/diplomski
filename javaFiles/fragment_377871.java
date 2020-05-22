class PrintDemo {

   public void printCount() {

      try {

         for(int i = 5; i > 0; i--) {
            System.out.println("Counter   ---   "  + i );
         }
      } catch (Exception e) {
         System.out.println("Thread  interrupted.");
      }
   }
}

class ThreadDemo extends Thread {
   private Thread t;
   private String threadName;
   PrintDemo  PD;

   ThreadDemo(String name,  PrintDemo pd) {
      threadName = name;
      PD = pd;
   }

   public void run() {

      synchronized(PD) {
         PD.printCount();
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }

   public void start () {
      System.out.println("Starting " +  threadName );

      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }

   public void joinInsideThread() throws InterruptedException {
       if (t != null){
           t.join();
       }
   }
}

public class TestThread {

   public static void main(String args[]) {
      PrintDemo PD = new PrintDemo();

      ThreadDemo T1 = new ThreadDemo("Thread - 1 ", PD);
      ThreadDemo T2 = new ThreadDemo("Thread - 2 ", PD);

      System.out.println("1");
      T1.start();
      System.out.println("2");
      T2.start();

      // wait for threads to end
      try {
         System.out.println("3");
         T1.joinInsideThread();
         System.out.println("4");
         T2.joinInsideThread();
         System.out.println("5");
      } catch (Exception e) {
         System.out.println("Interrupted");
      }
   }
}