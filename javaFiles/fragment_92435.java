import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTabbedPaneUI;


public class BorderlessTabsExample implements Runnable {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(MetalLookAndFeel.class.getName());
        } catch (Exception e) {
            // Nothing
        }
        SwingUtilities.invokeLater(new BorderlessTabsExample());
    }

    @Override
    public void run() {
        JTabbedPane tabber = new JTabbedPane();
        tabber.addTab("First", new JLabel("First"));
        tabber.addTab("Second", new JLabel("Second"));
        tabber.addTab("Third", new JLabel("Third"));
        // set the UI which will paint your tabs
        tabber.setUI(new MetalBorderlessTabbedPaneUI()); 
        JFrame frm = new JFrame("Tabber test");
        frm.add(tabber);
        frm.setSize(500, 400);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }

    private static class MetalBorderlessTabbedPaneUI extends MetalTabbedPaneUI {

        @Override
        protected void installDefaults() {
            super.installDefaults();
            if (contentBorderInsets != null) {
                contentBorderInsets = new Insets(contentBorderInsets.top, 0, 0, 0);
            }
        }

        @Override
        protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
            // Do nothing
        }

        @Override
        protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
            // Do nothing
        }

        @Override
        protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
            // Do nothing
        }

    }
}