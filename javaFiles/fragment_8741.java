import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SingleColumnOfButtonsLayout {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new GridLayout(0,1,10,10));
                gui.setBorder(new EmptyBorder(10,10,10,10));

                gui.add(new JButton("Start"));
                gui.add(new JButton("Reset"));
                gui.add(new JButton("A Very Long String"));

                JFrame f = new JFrame("Single Column of Buttons Layout");
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
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}