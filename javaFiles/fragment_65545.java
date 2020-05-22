/**
 * A panel that can be used in a JScrollPane which always adapts to the
 * width of the JScrollPane (so only vertical scrolling will happen).
 */
public class ParentWidthPanel extends JPanel implements Scrollable {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(final Rectangle visibleRect, final int orientation, final int direction) {
        return 5;
    }

    @Override
    public int getScrollableBlockIncrement(final Rectangle visibleRect, final int orientation, final int direction) {
        return 15;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
    if (getParent() instanceof JViewport) {
       return ((getParent()).getHeight() > getPreferredSize().height);
    }
    return false;
    }

}