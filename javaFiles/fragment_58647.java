import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * <code>TestScroll</code>.
 */
public class TestScroll {

    private static final String TEXT = "It's a very very very long text for label to test whether it can be scrolled";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TestScroll()::startUp);
    }

    /**
     * 
     */
    private void startUp() {
        JFrame frm = new JFrame();
        frm.add(new JScrollPane(new ScrollableLabel(TEXT)), BorderLayout.NORTH);
        frm.add(new JScrollPane(new JTree()));
        frm.add(new JScrollPane(new ScrollableLabel("Small text")), BorderLayout.SOUTH);
        frm.setSize(200, 300);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frm.setVisible(true);
    }

    private class ScrollableLabel extends JLabel implements Scrollable {

        /**
         * 
         */
        public ScrollableLabel(String text) {
            super(text);
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            if (getParent() == null || !(getParent().getParent() instanceof JScrollPane)) {
                return getPreferredSize();
            }
            JScrollPane scroller = (JScrollPane) getParent().getParent();
            Dimension actualSize = getParent().getSize();
            Dimension pref = getPreferredSize();
            Dimension result = new Dimension();
            result.height = pref.height
                    + pref.width < actualSize.width ? 2 : scroller.getHorizontalScrollBar().getPreferredSize().height + 2;
            result.width = pref.width
                    + pref.height < actualSize.height ? 2 : scroller.getVerticalScrollBar().getPreferredSize().width + 2;
            return result;
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            // TODO Auto-generated method stub
            return 10;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            // TODO Auto-generated method stub
            return 30;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            // TODO Auto-generated method stub
            return false;
        }

    }
}