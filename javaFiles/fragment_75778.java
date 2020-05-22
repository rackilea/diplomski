import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleTimer extends JPanel {
    private static final String TIME_FORMAT = "%02d:%02d:%02d";
    public static final int TIMER_DELAY = 100;
    private static final int PREF_W = 300;
    private static final int PREF_H = 100;
    private long startTime;
    private Timer myTimer;
    private JLabel timerLabel = new JLabel("00:00:00");
    private JCheckBox fastChkBox = new JCheckBox("Run Artificially Fast", false);

    public SimpleTimer() {
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(new JButton(new RestartAction("Restart", KeyEvent.VK_R)));
        centerPanel.add(fastChkBox);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Time passed: "));
        topPanel.add(timerLabel);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
    }

    private class RestartAction extends AbstractAction {
        public RestartAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (myTimer != null && myTimer.isRunning()) {
                myTimer.stop();
            }

            startTime = System.currentTimeMillis();
            myTimer = new Timer(TIMER_DELAY, new TimerListener());
            myTimer.start();
        }
    }

    // make it bigger
    @Override
    public Dimension getPreferredSize() {
        Dimension superSz = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSz;
        }
        int prefW = Math.max(superSz.width, PREF_W);
        int prefH = Math.max(superSz.height, PREF_H);
        return new Dimension(prefW, prefH);
    }


    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            long millis = System.currentTimeMillis() - startTime;

            if (fastChkBox.isSelected()) {
                millis *= 512;  // make time go faster
            }
            String text = String.format(TIME_FORMAT, 
                    TimeUnit.MILLISECONDS.toHours(millis) % 24,
                    TimeUnit.MILLISECONDS.toMinutes(millis) % 60,
                    TimeUnit.MILLISECONDS.toSeconds(millis) % 60);
            timerLabel.setText(text);
        }
    }

    private static void createAndShowGui() {
        SimpleTimer mainPanel = new SimpleTimer();

        JFrame frame = new JFrame("SimpleTimer");
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