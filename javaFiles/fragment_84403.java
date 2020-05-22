import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class CountToABillion implements Runnable {

    double count = 0;
    Timer progressTimer;

    public void echoCount() {
        System.out.println(count);
    }

    @Override
    public void run() {
        progressTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                echoCount();
            }
        });
        progressTimer.setRepeats(true);
        progressTimer.start();

        for (double x=0;x<1000000000;x++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            count = x;
        }
        progressTimer.stop();
    }
}