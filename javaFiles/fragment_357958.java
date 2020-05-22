import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = gbc.BOTH;
            gbc.gridx = 0;
            gbc.gridy = 0;

            JPanel filler = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(200, 300);
                }
            };
            filler.setBackground(Color.BLUE);

            add(filler, gbc);
            gbc.gridx++;
            add(new BoardPanel(), gbc);
        }

    }

    class BoardPanel extends JPanel {

        private static final int ROWS = 20;
        private static final int COLUMNS = 20;
        private int sqSize = 20;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(COLUMNS * sqSize, ROWS * sqSize);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    int x = j * sqSize;
                    int y = i * sqSize;
                    g.drawRect(x, y, sqSize, sqSize);

                }
            }

        }
    }

}