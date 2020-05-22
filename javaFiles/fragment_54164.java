import sun.misc.Signal;
import sun.misc.SignalHandler;

public class SigAbrt {

  private static volatile boolean abort = false;

  public static void main(String[] args) throws Exception {

    Signal.handle(new Signal("ABRT"), new SignalHandler () {
      public void handle(Signal sig) {
        System.out.println("got a SIGABRT");
        abort = true;
      }
    });

    for(int i=0; i<100; i++) {
      Thread.sleep(1000);
      System.out.print('.');
      if (abort) {
          System.out.println("ABORT");
          break;
      }
    }
  }
}