import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;    
import javax.swing.*;

@SuppressWarnings("serial")
public class ResetCounter extends JPanel {
    private static final int TIMER_DELAY = 1000; // 1 second delay
    private int counter = 0;  // our counter field
    private JLabel counterLabel = new JLabel("   0   ", SwingConstants.CENTER); // label to display counter value
    private JButton button = new JButton(new ButtonPressAction("Click Me", KeyEvent.VK_C));  // our button with its AbstractAction
    private Timer timer = new Timer(TIMER_DELAY, new TimerListener()); // the Swing Timer loaded with its delay and ActionListener

    public ResetCounter() {
        // make sure timer does not repeat
        timer.setRepeats(false);

        // create JPanel to hold JLabels that give counter information
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Count:"));
        topPanel.add(counterLabel);

        // JPanel to hold the button
        JPanel midPanel = new JPanel();
        midPanel.add(button);
        int ebGap = 15; // make mid panel bigger
        midPanel.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(midPanel, BorderLayout.CENTER);
    }

    // method that sets counter value **and** displays value in JLabel
    public void setCounter(int counter) {
        this.counter = counter;
        counterLabel.setText(String.valueOf(counter));
    }

    // ActionListener (and more) for the button
    private class ButtonPressAction extends AbstractAction {
        public ButtonPressAction(String name, int mnemonic) {
            super(name);  // text to show in button
            putValue(MNEMONIC_KEY, mnemonic);  // alt-key mnemonic key for button
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setCounter(counter + 1);  // re-sets the counter and displays it
            timer.restart();   // re-sets and runs the timer
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setCounter(0);  // this is all the timer does
        }
    }

    private static void createAndShowGui() {
        ResetCounter mainPanel = new ResetCounter();

        JFrame frame = new JFrame("ResetCounter");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }

}