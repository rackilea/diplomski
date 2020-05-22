import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @see https://stackoverflow.com/a/36243395/230513
 */
public class Test {

    private static final int ROW = 2;
    private static final int COL = 5;

    private void display() {
        JFrame f = new JFrame("Test");
        f.setLayout(new GridLayout(0, 1));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel top = new JPanel(new GridBagLayout());
        top.setBackground(Color.darkGray);
        JLabel label = new JLabel("Post no bills.");
        label.setForeground(Color.yellow);
        top.add(label);
        f.add(top);
        f.add(createGridPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JPanel createGridPanel() {
        JPanel p = new JPanel(new GridLayout(ROW, COL, 5, 5));
        p.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        p.setBackground(Color.yellow);
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                p.add(createSubPanel());
            }
        }
        return p;
    }

    private JPanel createSubPanel() {
        JPanel p = new JPanel(new GridLayout(0, 1));
        JPanel top = new JPanel();
        top.add(new JButton("One"));
        top.add(new JButton("Two"));
        JPanel bot = new JPanel();
        bot.add(new JRadioButton("A"));
        bot.add(new JRadioButton("B"));
        bot.add(new JRadioButton("C"));
        bot.add(new JRadioButton("D"));
        p.add(top);
        p.add(bot);
        return p;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}