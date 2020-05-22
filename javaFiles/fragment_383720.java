import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class SplitPane extends JFrame {

    private JPanel p1 = new JPanel(), p2 = new JPanel();
    private JSplitPane jsp;
    public SplitPane() {
        super("SplitPane example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        p1.setBackground(Color.orange);

        p2.setBackground(Color.green);

        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, p1, p2);
        jsp.setDividerLocation(getWidth() / 2);
        setContentPane(jsp);

        setSize(300, 300);

        setLocationRelativeTo(null);

        setVisible(true);

    }

    public static void main(String[] args) {
        new SplitPane();
    }

}