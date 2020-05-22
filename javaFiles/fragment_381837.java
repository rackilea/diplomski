import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Scrollable01 {

    public static void main(String[] args) {
        new Scrollable01();
    }

    public Scrollable01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                RefreshablePanel pane = new RefreshablePanel();
                pane.updateDescription("1. You're using null layouts, so nothing is going to work the way it should. Swing is designed at the core to utilise layout managers.");
                pane.updateDescription("2. You're RefreshablePanel has no discernible size, meaning that when you add to the scroll pane, the scroll pane is likely to simply think it's size should 0x0. RefreshablePanel needs to provide some kind of size hint back to the scrollpane, preferably via the getPreferredSize method");
                pane.updateDescription("3. You could use a JLabel (with text wrapped in html) or a non-editable JTextArea to achieve the same results");

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(pane));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class RefreshablePanel extends JPanel implements Scrollable {

        public String description = "";

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 1010);
        }

        @Override
        protected void paintComponent(Graphics g) {
            int x = 10;
            int y = 11;
            super.paintComponent(g);
            for (String line : description.split("\n")) {
                g.drawString(line, x, y += g.getFontMetrics().getHeight());
            }
        }

        void updateDescription(String dataToAppend) {
            description = description.concat("\n").concat(dataToAppend);
            System.out.println("The description is " + description);
            repaint();
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(400, 400);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 64;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 64;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }
    }
}