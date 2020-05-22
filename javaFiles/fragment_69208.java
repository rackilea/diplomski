@Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
        if(e.getID() == MouseEvent.MOUSE_PRESSED)
            getPopupMenu().setLocation(
                getLocationOnScreen().x+getWidth()/2-getPopupMenu().getWidth()/2,
                getLocationOnScreen().y+getHeight());
}