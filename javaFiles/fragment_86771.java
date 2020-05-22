tree.addMouseMotionListener(new MouseMotionAdapter() {
    @Override
    public void mouseMoved(MouseEvent e) {
        int x = (int) e.getPoint().getX();
        int y = (int) e.getPoint().getY();
        TreePath path = tree.getPathForLocation(x, y);
        if (path == null) {
            tree.setCursor(Cursor.getDefaultCursor());
        } else {
            tree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }
});