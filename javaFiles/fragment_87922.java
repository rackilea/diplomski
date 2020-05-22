import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestTimer extends JPanel {

    private JButton start1;
    private JLabel label;
    private JLabel timer1;
    private TimerListener listener;
    private int count = 30;
    private Timer javaTimer1 = new Timer(1000, null);

    public TestTimer() {

        label = new JLabel("Timer");
        timer1 = new JLabel("timer1");
        javaTimer1 = new Timer(1000, new TimerListener());
        javaTimer1.setRepeats(true);

        start1 = new JButton("Start Timer 1");

        add(label);
        add(timer1);
        add(start1);

        start1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                javaTimer1.start();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestTimer());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (count == 0) {
                javaTimer1.stop();
            } else {
                count--;
                timer1.setText("" + count);
            }
        }
    }
}