import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.Date;

public class E10U27 extends JFrame {
    public static void main(String[] args){

        // Prep the listener to respond
        class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {

                Date now = new Date();
                System.out.println(now);
            }
        }

        ActionListener listener = new TimerListener();
        final int DELAY = 1000; // Milliseconds between timer ticks
        Timer t = new Timer(DELAY, listener);
        t.start();

        (new E10U27()).setVisible(true);
    }
}