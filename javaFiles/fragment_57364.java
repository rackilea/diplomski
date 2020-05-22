public class PchangeThread extends Thread {
  private final Object _lock = new Object();
  Automation _automation;
  private final boolean _threadInterrupted;

  PchangeThread(Automation automation)
  {
    _automation = automation;
    _threadInterrupted = true;
  }

  @Override
  public void run()
  {
    while (true) {
      System.out.println("before entering loop");
      while (isThreadInterrupted()) {
        try {
          wait();
          System.out.println("after wait");
        } catch (InterruptedException ex) {
          System.out.println("thread2: caught interrupt!");
        }
      }
      process();
    }
  }

  private void process()
  {
    System.out.println("thread is running!");

  }

  public boolean isThreadInterrupted()
  {
    synchronized (_lock) {
      return _threadInterrupted;
    }
  }

  public void resumeThread()
  {
    synchronized (_lock) {
      _threadInterrupted = false;
      notify();
    }
  }
}