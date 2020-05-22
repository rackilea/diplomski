public void mouseClicked(MouseEvent e) {

    Point pointValues = new Point();
    pointValues.setLocation(e.getX(), e.getY());
    mousePointX = pointValues.x;
    mousePointY = pointValues.y;

    repaint();
}