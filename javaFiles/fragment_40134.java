static class ImageComponent extends JComponent 
        implements MouseListener, MouseMotionListener {
    BufferedImage img; 
    Point p1, p2;
    public ImageComponent() {
        addMouseListener(this); addMouseMotionListener(this);
    }
    public void set(BufferedImage img) {
        this.img = img;
        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        repaint();
    }
    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null)
            g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);
        if (p1 != null && p2 != null)
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
    @Override public void mousePressed(MouseEvent e) {
        p1 = e.getPoint();
    }
    @Override public void mouseDragged(MouseEvent e) {
        mouseReleased(e);
    }
    @Override public void mouseReleased(MouseEvent e) {
        p2 = e.getPoint();
        repaint();
    }
    @Override public void mouseMoved(MouseEvent e) {}
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}