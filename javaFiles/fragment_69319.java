this.addMouseMotionListener(new MouseMotionAdapter() {

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX() - mousePt.x;
        int dy = e.getY() - mousePt.y;
        textPt.setLocation(textPt.x + dx, textPt.y + dy);
        mousePt = e.getPoint();
        repaint();
    }
});