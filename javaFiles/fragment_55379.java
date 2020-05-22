import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Countdown {

    static JLabel label;

    // Method which defines the appearance of the window.   
    public static void showGUI() {
        JFrame frame = new JFrame("Simple Countdown");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Some Text");
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }

    // Define a new thread in which the countdown is counting down.
    public static Thread counter = new Thread() {
        public void run() {
            for (int i=10; i>0; i=i-1) {
                updateGUI(i,label);
                try {Thread.sleep(1000);} catch(InterruptedException e) {};
            }
        }
    };

    // A method which updates GUI (sets a new value of JLabel).
    private static void updateGUI(final int i, final JLabel label) {
        SwingUtilities.invokeLater( 
            new Runnable() {
                public void run() {
                    label.setText("You have " + i + " seconds.");
                }
            }
        );
    }
}