import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/** @see https://stackoverflow.com/questions/7818752 */
public class JTabbedPaneDemo extends JPanel {

    private JPopupMenu menu = new JPopupMenu();

    public JTabbedPaneDemo() {
        Icon icon = UIManager.getIcon("html.pendingImage");
        final JTabbedPane jtb = new JTabbedPane();

        JPanel jplInnerPanel1 = createInnerPanel("Tab 1: Tooltip and Icon");
        jtb.addTab("One", icon, jplInnerPanel1, "Tab 1");
        jtb.setSelectedIndex(0);

        JPanel jplInnerPanel2 = createInnerPanel("Tab 2: Icon only");
        jtb.addTab("Two", icon, jplInnerPanel2);

        JPanel jplInnerPanel3 = createInnerPanel("Tab 3: Tooltip and Icon");
        jtb.addTab("Three", icon, jplInnerPanel3, "Tab 3");

        JPanel jplInnerPanel4 = createInnerPanel("Tab 4: Text only");
        jtb.addTab("Four", jplInnerPanel4);

        menu.add(new JMenuItem("Item 1"));
        menu.add(new JMenuItem("Item 2"));

        JLabel tab4Label = new JLabel();
        tab4Label.setText("Four");
        jtb.setTabComponentAt(3, tab4Label);
        tab4Label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            private void maybeShowPopup(MouseEvent e) {
                jtb.getModel().setSelectedIndex(3);
                if (e.isPopupTrigger()) {
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        setLayout(new GridLayout());
        add(jtb);
    }

    private JPanel createInnerPanel(String text) {
        JPanel jplPanel = new JPanel();
        JLabel jlbDisplay = new JLabel(text);
        jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
        jplPanel.setLayout(new GridLayout(1, 1));
        jplPanel.add(jlbDisplay);
        return jplPanel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("TabbedPane Source Demo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JTabbedPaneDemo());
                frame.pack();
                frame.setSize(400, 125);
                frame.setVisible(true);
            }
        });
    }
}