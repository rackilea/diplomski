import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

public class CountDownTest extends JPanel {
    private static final Integer[] SECONDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private JSpinner secondsSpinner = new JSpinner(new SpinnerListModel(Arrays.asList(SECONDS)));

    public CountDownTest() {
        add(secondsSpinner);
        add(new JButton(new StartCountDownAction(this, "Start Count Down")));
    }

    public int getSecondsSpinnerValue() {
        return (Integer) secondsSpinner.getValue();
    }

    private static void createAndShowGui() {
        CountDownTest mainPanel = new CountDownTest();

        JFrame frame = new JFrame("CountDownTest");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

class StartCountDownAction extends AbstractAction {
    private CountDownTest countDownTest;
    private Timer timer;

    public StartCountDownAction(CountDownTest countDownTest, String name) {
        super(name);
        this.countDownTest = countDownTest;
        int mnemonic = (int) name.charAt(0);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (timer != null && timer.isRunning()) {
            // don't start a new Timer when one is running
            return; 
        }
        int seconds = countDownTest.getSecondsSpinnerValue();
        timer = new Timer(seconds * 1000, new TimerListener(countDownTest));
        timer.setRepeats(false);
        timer.start();
    }
}

class TimerListener implements ActionListener {
    private CountDownTest countDownTest;

    public TimerListener(CountDownTest countDownTest) {
        this.countDownTest = countDownTest;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(countDownTest, "Timer Done!");
    }
}