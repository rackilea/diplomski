import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 * @see http://stackoverflow.com/a/16363072/230513
 */
public class Test {

    private static class CursorPanel extends JPanel {

        private static final Icon ICON = UIManager.getIcon("html.pendingImage");
        private Cursor cursor;

        public CursorPanel(final Cursor cursor) {
            this.cursor = cursor;
            String name = cursor.getName();
            JButton button = new JButton(name, ICON);
            button.setCursor(cursor);
            button.setToolTipText(name);
            this.add(button);
            final JPanel panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(200, 125);
                }
            };
            panel.setCursor(cursor);
            panel.setBorder(new TitledBorder(name));
            this.add(panel);
        }
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        f.add(new CursorPanel(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)));
        f.add(new CursorPanel(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}