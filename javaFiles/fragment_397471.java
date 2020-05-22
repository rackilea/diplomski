import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        JButton[][] levels = new JButton[3][8];

        public TestPane() {
            setSize(1600, 1000);
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(25, 25, 25, 25);
            gbc.fill = GridBagConstraints.BOTH;

            int count = 1;
            for (int r = 0; r < 3; r++) {
                gbc.gridx = 0;
                for (int c = 0; c < 8; c++) {
                    levels[r][c] = new JButton(String.valueOf(count));
                    levels[r][c].setMargin(new Insets(50, 50, 50, 50));
                    this.add(levels[r][c], gbc);
                    gbc.gridx++;
                    count++;
                }
                gbc.gridy++;
            }
        }
    }

}