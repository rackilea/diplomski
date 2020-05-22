import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Example {

    public static void main(String[] args) {
        new Example();
    }

    public Example() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame jFrame = new JFrame();
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // main panel
                JPanel pan = new JPanel();
                pan.setLayout(new GridLayout(1, 2));
                pan.setBackground(Color.BLUE);
                jFrame.getContentPane().add(pan, BorderLayout.CENTER);
                // left panel
                JPanel left = getContentPanel(GridBagConstraints.CENTER);
                left.setBackground(Color.ORANGE);
                pan.add(new JScrollPane(left));
                // right panel (with scroll pane)
                JPanel right = getContentPanel(GridBagConstraints.WEST);
                right.setBackground(Color.YELLOW);
                JScrollPane scr = new JScrollPane(right);
                scr.setBackground(Color.CYAN);
                scr.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
                pan.add(scr);

                jFrame.setSize(400, 400);
                jFrame.setVisible(true);
            }
        });
    }

    private static JPanel getContentPanel(int anchor) {
        JPanel rtn = new JPanel();
        rtn.setLayout(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.gridx = 0;
        cs.anchor = anchor;
        cs.weightx = 1;
        for (int i = 0; i < 100; i++) {
            JLabel label = new JLabel("Item " + (i + 1));
            label.setBackground(Color.DARK_GRAY);
            cs.gridy = i;
            rtn.add(label, cs);
        }
        rtn.setBackground(Color.GREEN);
        return rtn;
    }

}