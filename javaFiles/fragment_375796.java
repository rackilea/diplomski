import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JLabel label;
        private StopWatch sw;

        public TestPane() {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            label = new JLabel("...");
            add(label, gbc);

            sw = new StopWatch(label);

            JButton btn = new JButton("Resume");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sw.setPaused(!sw.isPaused());
                    btn.setText(sw.isPaused() ? "Resume" : "Pause");
                }
            });
            add(btn, gbc);
        }

    }

    public class StopWatch {

        private Timer timer;
        private JLabel label;

        private int runningTime;
        private long tickTime;

        public StopWatch(JLabel label) {
            this.label = label;
            timer = new Timer(10, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    runningTime += (System.currentTimeMillis() - tickTime);
                    System.out.println(runningTime);
                    update(runningTime);
                    tickTime = System.currentTimeMillis();
                }
            });
        }

        public void setPaused(boolean paused) {
            if (paused && timer.isRunning()) {
                timer.stop();
            } else if (!paused && !timer.isRunning()) {
                tickTime = System.currentTimeMillis();
                timer.start();
            }
        }

        public boolean isPaused()  {
            return !timer.isRunning();
        }

        private void update(long dT) {
            long x = (dT / 1000) % 60;
            long y = (dT / 60000) % 1000;
            if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
                label.setText("0" + String.valueOf((dT / 60000) % 1000) + ":0" + String.valueOf((dT / 1000) % 60) + "," + String.valueOf((dT) % 1000));
            } else if (x > 9 && y >= 0 && y <= 9) {
                label.setText("0" + String.valueOf((dT / 60000) % 1000) + ":" + String.valueOf((dT / 1000) % 60) + "," + String.valueOf((dT) % 1000));
            } else if (x >= 0 && x <= 9 && y > 9) {
                label.setText(String.valueOf((dT / 60000) % 1000) + ":0" + String.valueOf((dT / 1000) % 60) + "," + String.valueOf((dT) % 1000));
            } else if (x > 9 && y > 9) {
                label.setText(String.valueOf((dT / 60000) % 1000) + ":" + String.valueOf((dT / 1000) % 60) + "," + String.valueOf((dT) % 1000));
            }
        }

    }
}