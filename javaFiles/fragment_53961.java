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
                Rectangle viewBounds = getScreenViewableBounds();
                frame.setSize(frame.getWidth(), viewBounds.height);
                frame.setLocation(viewBounds.x, viewBounds.y);
                frame.setVisible(true);
            }

            private JPanel getPanel() {
                JPanel panel = new JPanel();
                Box box = Box.createVerticalBox();
                for (int i = 1; i <= 100; i++) {
                    box.add(new JLabel("This is Label #" + i));
                }
                panel.add(box);
                return panel;
            }
        });
    }

    public static Rectangle getScreenViewableBounds() {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        Rectangle bounds = new Rectangle(0, 0, 0, 0);

        if (gd != null) {

            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            bounds = gc.getBounds();

            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);

            bounds.x += insets.left;
            bounds.y += insets.top;
            bounds.width -= (insets.left + insets.right);
            bounds.height -= (insets.top + insets.bottom);

        }

        return bounds;

    }
}