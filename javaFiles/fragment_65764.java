import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class JFrameTest {

  public static void main(String[] args) {

    final Timer t = new Timer();
    t.start();

    JFrame jf = new JFrame("GOPI");
    jf.setVisible(true);
    jf.setSize(100, 100);
    jf.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        t.stopTimer();
      }
    });
    System.out.println("JFrameTest.main() DONE");
  }
}

class Timer extends Thread {
  boolean stop = false;

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (stop)
        break;
      System.out.println("Counting :" + i);
    }
    System.out.println("Timer exit");
  }

  public void stopTimer() {
    stop = true;
  }
}