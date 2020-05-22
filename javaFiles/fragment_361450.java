import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TimerTest {
public static void main(String[] args) {

    final JFrame frame = new JFrame();
    final JProgressBar ps = new JProgressBar();
    final Timer timer = new Timer(100, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int value = ps.getValue() + 1;
            ps.setValue(value);
        }

    });

    ps.addChangeListener(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (ps.getValue() == 100) {
                timer.stop();
                frame.dispose();
            }
        }
    });
    frame.setSize(600, 400);
    frame.add(ps);
    frame.pack();
    frame.setVisible(true);
    timer.start();
}