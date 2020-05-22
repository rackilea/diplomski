import java.awt.*;
import javax.swing.*;

/**
 * JFrame with a progress bar and button. With the size of their own.
 *
 * @author Tadesse
 */
public class Test extends JFrame {

    JButton button = new JButton("Cancel");
    JProgressBar progressBar = new JProgressBar();

    public Test() {
        GridBagConstraints g = new GridBagConstraints();
        setLayout(new GridBagLayout());
        set(g, 0, 0, GridBagConstraints.CENTER);
        add(progressBar, g);
        set(g, 0, 1, GridBagConstraints.CENTER);
        add(button, g);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 100);
        setVisible(true);
    }

    public void set(GridBagConstraints c, int x, int y, int anchor) {
        c.gridx = x;
        c.gridy = y;
        c.anchor = anchor;
    }

    public static void main(String[] args) {
        new Test();
    }
}