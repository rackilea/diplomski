import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TooManyListenersException;

import javax.swing.JComponent;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class AutoscrollWorkaround implements DropTargetListener, ActionListener {

    private JComponent component;

    private Point lastPosition;

    private Rectangle outer;
    private Rectangle inner;

    private Timer timer;
    private int hysteresis = 10;

    private static final int AUTOSCROLL_INSET = 10;

    public AutoscrollWorkaround(JComponent component) {
        if (!(component instanceof Scrollable)) {
            throw new IllegalArgumentException("Component must be Scrollable for autoscroll to work!");
        }
        this.component = component;
        outer = new Rectangle();
        inner = new Rectangle();

        Toolkit t = Toolkit.getDefaultToolkit();
        Integer prop;

        prop = (Integer)t.getDesktopProperty("DnD.Autoscroll.interval");
        timer = new Timer(prop == null ? 100 : prop.intValue(), this);

        prop = (Integer)t.getDesktopProperty("DnD.Autoscroll.initialDelay");
        timer.setInitialDelay(prop == null ? 100 : prop.intValue());

        prop = (Integer)t.getDesktopProperty("DnD.Autoscroll.cursorHysteresis");
        if (prop != null) {
            hysteresis = prop.intValue();
        }
    }

    @Override
    public void dragEnter(DropTargetDragEvent e) {
        lastPosition = e.getLocation();
        SwingUtilities.convertPointToScreen(lastPosition, component);
        updateRegion();
    }

    @Override
    public void dragOver(DropTargetDragEvent e) {
        Point p = e.getLocation();
        SwingUtilities.convertPointToScreen(p, component);

        if (Math.abs(p.x - lastPosition.x) > hysteresis
                || Math.abs(p.y - lastPosition.y) > hysteresis) {
            // no autoscroll
            if (timer.isRunning()) timer.stop();
        } else {
            if (!timer.isRunning()) timer.start();
        }

        lastPosition = p;
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        cleanup();
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        cleanup();
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent e) {
    }

    private void updateRegion() {
        // compute the outer
        Rectangle visible = component.getVisibleRect();
        outer.setBounds(visible.x, visible.y, visible.width, visible.height);

        // compute the insets
        Insets i = new Insets(0, 0, 0, 0);
        if (component instanceof Scrollable) {
            int minSize = 2 * AUTOSCROLL_INSET;

            if (visible.width >= minSize) {
                i.left = i.right = AUTOSCROLL_INSET;
            }

            if (visible.height >= minSize) {
                i.top = i.bottom = AUTOSCROLL_INSET;
            }
        }

        // set the inner from the insets
        inner.setBounds(visible.x + i.left,
                      visible.y + i.top,
                      visible.width - (i.left + i.right),
                      visible.height - (i.top  + i.bottom));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateRegion();
        Point componentPosition = new Point(lastPosition);
        SwingUtilities.convertPointFromScreen(componentPosition, component);
        if (outer.contains(componentPosition) && !inner.contains(componentPosition)) {
            autoscroll(componentPosition);
        }
    }

    private void autoscroll(Point position) {
        Scrollable s = (Scrollable) component;
        if (position.y < inner.y) {
            // scroll upward
            int dy = s.getScrollableUnitIncrement(outer, SwingConstants.VERTICAL, -1);
            Rectangle r = new Rectangle(inner.x, outer.y - dy, inner.width, dy);
            component.scrollRectToVisible(r);
        } else if (position.y > (inner.y + inner.height)) {
            // scroll downard
            int dy = s.getScrollableUnitIncrement(outer, SwingConstants.VERTICAL, 1);
            Rectangle r = new Rectangle(inner.x, outer.y + outer.height, inner.width, dy);
            component.scrollRectToVisible(r);
        }

        if (position.x < inner.x) {
            // scroll left
            int dx = s.getScrollableUnitIncrement(outer, SwingConstants.HORIZONTAL, -1);
            Rectangle r = new Rectangle(outer.x - dx, inner.y, dx, inner.height);
            component.scrollRectToVisible(r);
        } else if (position.x > (inner.x + inner.width)) {
            // scroll right
            int dx = s.getScrollableUnitIncrement(outer, SwingConstants.HORIZONTAL, 1);
            Rectangle r = new Rectangle(outer.x + outer.width, inner.y, dx, inner.height);
            component.scrollRectToVisible(r);
        }
    }

    private void cleanup() {
        timer.stop();
    }
}