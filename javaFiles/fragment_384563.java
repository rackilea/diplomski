@Override
public void mouseClicked(MouseEvent evt) {
    if (!SwingUtilities.isLeftMouseButton(evt)) return;
    Component[] siblings = layeredPane.getComponentsInLayer(JLayeredPane.getLayer(this));
    int pos = layeredPane.getPosition(this);
    for (Component sibling : siblings) {
        // interested in siblings below
        if (layeredPane.getPosition(sibling) > pos) {
            // convert coordinates
            Point p = SwingUtilities.convertPoint(this, evt.getX(), evt.getY(), sibling);
            if (sibling.contains(p)) {
                // convert event
                MouseEvent dispatch = SwingUtilities.convertMouseEvent(
                        this, evt, sibling);
                // manually dispatch the event
                sibling.dispatchEvent(dispatch);
                break;
            }
        }

    }
    // do my own work
    System.out.println(getName() + evt);
}