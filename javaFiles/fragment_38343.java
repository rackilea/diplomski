public void update(Graphics g, JComponent c) {
    if (c.isOpaque()) {
        g.setColor(c.getBackground());
        g.fillRect(0, 0, c.getWidth(),c.getHeight());
    }
    paint(g, c);
}