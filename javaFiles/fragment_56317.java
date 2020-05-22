import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestTimer extends JPanel {
    private static final String FORMAT_TXT = "%02d:%02d";
    private int seconds = 0;
    private int minutes = 10;
    private JLabel lblTime = new JLabel(String.format(FORMAT_TXT, minutes, seconds));
    private int timerDelay = 1000; // msecs
    private Timer myTimer = new Timer(timerDelay, e -> countDown());

    public TestTimer() {
        lblTime.setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(new BorderLayout());
        add(lblTime, BorderLayout.PAGE_START);
        add(new JButton(new AbstractAction("Start") {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (myTimer != null && !myTimer.isRunning()) {
                    myTimer.start();                    
                }
            }
        }));
    }

    private void countDown() {
        if (minutes == 0 && seconds == 0) {
            if (myTimer != null && myTimer.isRunning()) {
                myTimer.stop(); // stop the Timer if time's up
            }
            JOptionPane.showMessageDialog(this, "time's up!");
            // new Result().setVisible(true);
            // this.dispose();
        } else if (seconds == 0) {
            minutes--;
            seconds = 59;
        } else {
            seconds--; // update seconds
        }
        // create label's text and update JLabel
        String text = String.format("%02d:%02d", minutes, seconds);
        lblTime.setText(text);
    }

    private static void createAndShowGui() {
        TestTimer mainPanel = new TestTimer();

        JFrame frame = new JFrame("Test Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}