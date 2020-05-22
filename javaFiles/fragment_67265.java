import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestPanel extends JPanel {
    private static final int PREF_W = 500;
    private static final int PREF_H = 400;
    private static final int TIMER_DELAY = 2 * 1000; // 2 seconds

    public TestPanel() {
        JLabel label = new JLabel("Test GUI");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));

        setPreferredSize(new Dimension(PREF_W, PREF_H));
        setLayout(new GridBagLayout());
        add(label);
    }


    // this code is called from a main method, but could be called anywhere, from 
    // a JButton's action listener perhaps. If so, then I'd probably not create
    // a new JFrame but rather a JDialog, and place my TestPanel within it
    private static void createAndShowGui() {
        TestPanel mainPanel = new TestPanel();

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        if (Math.random() > 0.5) {
            // 50% chance of this happening
            String message = "Error In Opening Main App";
            int type = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(frame, message, "Error", type);
            frame.dispose();
        } else {
            // run timer
            new Timer(TIMER_DELAY, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();  // dispose gui when time's up
                    ((Timer) e.getSource()).stop();  // and stop the timer
                }

            }).start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

}