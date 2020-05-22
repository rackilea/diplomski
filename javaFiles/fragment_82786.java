import java.awt.*;
import javax.swing.*;

public class Page1311Test extends JPanel {

    public JScrollPane pane = null;
    public JPanel panel = null;

    /**
     * Create the panel.
     */
    public Page1311Test() {
        setLayout(new GridLayout());
        //JPanel panel = new JPanel(); //shadowed class attribute
        panel = new JPanel(new GridLayout(0, 1, 1, 40));

        for (int ii = 0; ii < 17; ii++) {
            panel.add(new Page13111SubPanel(ii));
        }

        pane = new JScrollPane(panel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(pane);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setLocation(0, 0);
        frame.add(new Page1311Test());
        frame.pack();
        frame.setVisible(true);
    }
}

class Page13111SubPanel extends JPanel {

    /**
     * Create the panel.
     */
    public Page13111SubPanel(int num) {
        //setSize(1000, 130); // Don't set sizes using 'magic numbers'
        setLayout(new GridLayout(3, 3, 40, 35));

        add(new JLabel(num + " Vehicle Companies:asdddddddddddddddd1"));
        add(new JLabel("Vehicle Make:"));
        add(new JLabel("Vehicle Model"));
        add(new JLabel("Vehicle Number"));
        add(new JLabel("Vehicle Driver:"));
        add(new JLabel("Vehicle Wheels"));
        add(new JLabel("Vehicle Air Con"));
    }
}