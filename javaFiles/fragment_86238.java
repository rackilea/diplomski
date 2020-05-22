import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import javax.swing.*;

@SuppressWarnings("serial")
public class TimerGui extends JPanel {
    private static final int TIMER_DELAY = 50;
    private LocalTime startTime;
    private LocalTime stopTime;
    private JLabel timerLabel = new JLabel("00:00", SwingConstants.CENTER);
    private Timer timer = null;
    private JButton goButton = new JButton("Go");
    private JButton stopButton = new JButton("Stop");
    private JButton exitButton = new JButton("Exit");

    public TimerGui() {
        // make the timer label's text larger
        timerLabel.setFont(timerLabel.getFont().deriveFont(Font.BOLD, 24f));
        timerLabel.setBorder(BorderFactory.createTitledBorder("Elapsed Time"));

        // alt-key hotkeys for my buttons
        goButton.setMnemonic(KeyEvent.VK_G);
        stopButton.setMnemonic(KeyEvent.VK_S);
        exitButton.setMnemonic(KeyEvent.VK_X);

        // add ActionListeners
        goButton.addActionListener(e -> {
            // reset startTime
            startTime = LocalTime.now();

            // if timer running, stop it
            if (timer != null && timer.isRunning()) {
                timer.stop();
            }
            timer = new Timer(TIMER_DELAY, new TimerListener());
            timer.start();
        });
        stopButton.addActionListener(e -> {
            // if start has already been pressed
            if (startTime != null) {
                // if timer running, stop it
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                    stopTime = LocalTime.now();
                }
                long minuteDifference = startTime.until(stopTime, ChronoUnit.MINUTES);
                long secondDifference = startTime.until(stopTime, ChronoUnit.SECONDS);
                System.out.println("Time difference in minutes: " + minuteDifference);
                System.out.println("Time difference in seconds: " + secondDifference);
            }            
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(goButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(exitButton);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(timerLabel, BorderLayout.PAGE_START);
        add(buttonPanel);
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LocalTime endTime = LocalTime.now();
            long secondDifference = startTime.until(endTime, ChronoUnit.SECONDS);

            int minutes = (int) (secondDifference / 60);
            int seconds = (int) (secondDifference % 60);
            String timeText = String.format("%02d:%02d", minutes, seconds);
            timerLabel.setText(timeText);
        }
    }

    private static void createAndShowGui() {
        TimerGui mainPanel = new TimerGui();

        JFrame frame = new JFrame("Timer");
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