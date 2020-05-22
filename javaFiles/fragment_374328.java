@BeforeClass
  public static void startProess() throws Exception {
    SomeProcess .getInstance().startIfNotRunning();
  }

public class SomeProcess {
  private Thread thread;
  private Process process;


  private static SomeProcess instance = new SomeProcess ();
  public static SomeProcess getInstance() {
    return instance;
  }

  public synchronized void startIfNotRunning() throws Exception {
      (...) 
      // check if it's not running and if not start
      (...)
      instance.start();
      (...)
  }

  public synchronized void stop() throws Exception {
      process.destroy()
  }

 private synchronized void start() throws Exception {
    thread = new Thread(new Runnable() {
        @Override
        public void run() {
           process = Runtime.exec("/path/yo/your/app");
        }

      });


    thread.start();

    // put some code to wait until the process has initialized (if it requires some time for initialization.

  }

}