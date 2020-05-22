public class LineDrawer2 extends Canvas implements MouseListener, MouseMotionListener {
    ...
    public LineDrawer2() {
        ...
        addMouseListener(this);
        addMouseMotionListener(this);
    }