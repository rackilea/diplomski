class ThreadFibonaci implements Runnable{

  public static volatile long fn;
  public static volatile boolean printed = false;
  private int n;

  public ThreadFibonaci(int n){
    this.n = n;
  }

  public void run(){
    long f0 = 0;
    fn = f0;
    while (!printed) {
      try{
        Thread.sleep(500);
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    long f1 = 1;
    fn = f1;
    printed = false;
    while (!printed) {
      try{
        Thread.sleep(500);
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    for(int i=0; i<n; i++){
      fn = f0 + f1;
      f0 = f1;
      f1 = fn;
      printed = false;
      while (!printed) {
        try{
          Thread.sleep(500);
        }catch(Exception e){
          e.printStackTrace();
        }
      }
    }
 }
}

class ThreadOutput extends Thread{

 public ThreadOutput(){
   setDaemon(true);
 }

 public void run(){
   while(true){
     while (ThreadFibonaci.printed) {
       try{
         Thread.sleep(500);
        }catch(Exception e){
          e.printStackTrace();
        }
     }
     System.out.println(ThreadFibonaci.fn);
     ThreadFibonaci.printed = true;
  }
 }
}