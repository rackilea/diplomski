@Override
public void dragDropEnd(DragSourceDropEvent dsde) {
    // If the drop was not successful, we need to
    // return the component back to it's previous
    // parent
    if (!dsde.getDropSuccess()) {
        getParent().add(getPanel());
    } else {
        getPanel().remove(getPanel());
    }
    getParent().invalidate();
    getParent().repaint();
}