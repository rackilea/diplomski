import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLayout {

    public static void main(String[] args) {
        new TestLayout();
    }

    public TestLayout() {
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

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;

            add(new ABigPanel(), gbc);

            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new ASmallPanel(), gbc);
            add(new ASmallerPanel(), gbc);
        }

    }

    public class ABigPanel extends JPanel {

        public ABigPanel() {
            setBackground(Color.RED);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

    }

    public class ASmallPanel extends JPanel {

        public ASmallPanel() {
            setBackground(Color.GREEN);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 180);
        }

    }

    public class ASmallerPanel extends JPanel {

        public ASmallerPanel() {
            setBackground(Color.CYAN);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 40);
        }

    }

}