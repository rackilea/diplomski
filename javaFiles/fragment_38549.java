import sun.misc.Signal;
import sun.misc.SignalHandler;

public class SigHupDemo {
  public static void main(String[] args) throws Exception {

    // you can also register for "TERM" - SIGTERM
    Signal.handle(new Signal("HUP"), new SignalHandler () {
      public void handle(Signal sig) {
        System.out.println("got a SIGHUP");
        // do what you want to do in such case
        // also include to end your daemon
      }
    });

    for(int i=0; i<100; i++) {
      Thread.sleep(1000);
      System.out.print('.');
    }
  }
}