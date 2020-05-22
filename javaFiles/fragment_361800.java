public void mouseMoved(MouseEvent e) {
    if (isDrawingMode) {
        Point point = e.getPoint();
        pointList.add(new Dot(point, c));

        repaint();
    }
}