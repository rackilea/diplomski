class MyMouse extends MouseAdapter {
    private Point pointPressed = null;

    @Override
    public void mousePressed(MouseEvent e) {
        pointPressed = e.getPoint();
    } 

    @Override
    public void mouseDragged(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Point pointDragged = e.getPoint();
        Point location = label.getLocation();
        int dx = pointDragged.x - pointPressed.x;
        int dy = pointDragged.y - pointPressed.y;
        location.translate(dx, dy);
        label.setLocation(location);
        Container container = label.getParent();
        container.repaint();
    }
}