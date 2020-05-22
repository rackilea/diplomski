import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CenteredCombos {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                String[] values = {"Dog","Cat"};
                // put the controls in a single column, with a little space.
                JPanel controlPanel = new JPanel(new GridLayout(0,1,5,5));
                for (int ii=0; ii<4; ii++) {
                    controlPanel.add(new JComboBox(values));
                }

                // the GUI as seen by the user (without frame)
                // The GBL is used to center the controlPanel
                JPanel gui = new JPanel(new GridBagLayout());
                gui.setBorder(new EmptyBorder(2, 3, 2, 3));
                gui.add(controlPanel);

                // Make the BG panel more clear..
                gui.setBackground(Color.WHITE);

                JFrame f = new JFrame("Demo");
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}