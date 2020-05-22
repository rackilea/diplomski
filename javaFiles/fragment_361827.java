import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StopClock {

    JLabel label = new JLabel("00:00:00");;
    Timer timer = new Timer(1000, new TimerListener());

    StopClock() {

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        startButton.addActionListener(new StartActionListener());
        stopButton.addActionListener(new StopActionListener());

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(startButton);
        panel.add(stopButton);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setTitle("Stop Clock");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> new StopClock());
    }

    class StartActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            timer.start();
        }
    }

    class StopActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            timer.stop();
        }
    }

    class TimerListener implements ActionListener {

        int sec = 0;
        int hr = 0;
        int min = 0;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (sec > 59) {
                min++;
                sec = 0;
            }
            if (min > 59) {
                hr++;
                min = 0;
            }
            if (hr > 12) {
                hr = 0;
            }
            sec++;
            String str = hr + ":" + min + ":" + sec;
            label.setText(str);
        }
    }
}