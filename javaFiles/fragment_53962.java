import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ScrollPaneTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                JTabbedPane tabbedPane = new JTabbedPane();

                tabbedPane.addTab("Tab 1", new JScrollPane(getPanel()));
                tabbedPane.addTab("Tab 2", new JScrollPane(getPanel()));

                frame.setContentPane(tabbedPane);
                frame.pack();
                frame.setVisible(true);
            }

            private JPanel getPanel() {
                JPanel panel = new ScrollablePane();
                Box box = Box.createVerticalBox();
                for (int i = 1; i <= 100; i++) {
                    box.add(new JLabel("This is Label #" + i));
                }
                panel.add(box);
                return panel;
            }
        });
    }

    public static class ScrollablePane extends JPanel implements Scrollable {

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(200, 400);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 32;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 32;
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