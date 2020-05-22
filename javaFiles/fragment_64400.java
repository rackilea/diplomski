[...]
    MouseAdapterImpl listener = new MouseAdapterImpl(tree);
    tree.addMouseListener(listener);
    tree.addMouseMotionListener(listener);
    tree.addMouseWheelListener(listener);
[...]
private class MouseAdapterImpl implements MouseListener, MouseWheelListener, MouseMotionListener
{
    private final JTree tree;
    private int lastRow = -1;

    public MouseAdapterImpl(JTree tree)
    {
        this.tree = tree;
    }

    /**
     * Returns the mouse position relative to the JTree row.
     * <p/>
     * @param e the mouse event
     */
    private void forwardEvent(MouseEvent e)
    {
        int row = tree.getRowForLocation(e.getX(), e.getY());
        Rectangle bounds;
        Point point;
        if (row == -1)
        {
            bounds = null;
            point = null;
        }
        else
        {
            bounds = tree.getRowBounds(row);
            point = new Point(e.getX() - bounds.x, e.getY() - bounds.y);
        }
        if (lastRow != row)
        {
            if (lastRow != -1)
            {
                Rectangle lastBounds = tree.getRowBounds(lastRow);
                if (lastBounds != null)
                {
                    Point lastPoint = new Point(e.getX() - lastBounds.x, e.getY() - lastBounds.y);
                    dispatchEvent(new MouseEvent(checkbox, MouseEvent.MOUSE_EXITED,
                        System.currentTimeMillis(), 0, lastPoint.x, lastPoint.y, 0, false, 0), lastRow);
                }
            }
            if (row != -1)
            {
                dispatchEvent(new MouseEvent(checkbox, MouseEvent.MOUSE_ENTERED,
                    System.currentTimeMillis(), 0, point.x, point.y, 0, false, 0), row);
            }
        }
        lastRow = row;
        if (row == -1)
            return;
        dispatchEvent(new MouseEvent(checkbox, e.getID(),
            System.currentTimeMillis(), e.getModifiers(), point.x, point.y, e.getClickCount(),
            e.isPopupTrigger(), e.getButton()), row);
    }

    private void dispatchEvent(MouseEvent e, int row)
    {
        checkbox.dispatchEvent(e);
        TreePath pathForLocation = tree.getPathForRow(row);
        if (pathForLocation == null)
            return;
        Object lastPathComponent = pathForLocation.getLastPathComponent();
        if (lastPathComponent instanceof DefaultMutableTreeNode)
        {
            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            model.nodeChanged((DefaultMutableTreeNode) lastPathComponent);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        forwardEvent(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        forwardEvent(e);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        forwardEvent(e);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        forwardEvent(e);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        forwardEvent(e);
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        forwardEvent(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        forwardEvent(e);
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        forwardEvent(e);
    }
}