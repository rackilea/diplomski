public class Main extends Thread {
  //...

  public void run(){
    //Initialize all threads with common monitor object
    Object monitor = new Object();
    for (int i = 0; i < 3; i++) {
      threads.add(new Thread(new Task(i + 65, monitor)));
    }
    long cT = System.currentTimeMillis();
    for (int i = 0; i < threads.size(); i++) {
      //All threads will start, and immediately pause on monitor.wait()
      threads.get(i).start();
    }
    synchronized(monitor){
      while (System.currentTimeMillis() - cT < 10000) {
        //All threads are currently waiting, so we need to wake one random
        //thread up by calling notify on monitor. Other thread will not run yet,
        //because this thread still holds the monitor.
        monitor.notify();

        //Make this thread wait, which will temporarily release the monitor
        //and let the notified thread run.
        monitor.wait();
      }
    }
  }
}

//...

public class Task implements Runnable{
  int nr;
  char character;
  Object monitor;

  public Task(int literaASCII, Object monitor) {
    this.nr = 0;
    this.monitor = monitor;
    character = (char) (literaASCII);
  }

  @Override
  public void run() {
    synchronized(monitor){
      while (true) {
        //Pause this thread and let some other random thread
        //do the work. When other thread finishes and calls notify()
        //this thread will continue (if this thread is picked).
        monitor.wait();

        try {
          System.out.print(nr + "" + character + ", ");
          nr++;
          int r = (int) ((Math.random() * 500) + 500); // <500ms,1000ms)

          Thread.sleep(r);
        } catch (Exception e) {
          e.printStackTrace();
        }

        //This thread has finished work for now. 
        //Let one other random thread know.
        monitor.notify();

        //Other thread will not be able to do work until this thread 
        //releases the monitor by calling monitor.wait() or 
        //completely exists the synchronized(monitor){ ... } block.
      }
    }
  }
}