protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g.create();
    g2.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
    g2.drawLine(0, getHeight() / 2, getWidth(), getHeight()/ 2);
    g2.translate((getWidth() / 2.0) - 50, (getHeight() / 2.0) - 50);
    g2.scale(1, -1);
    g2.rotate(45 * Math.PI / 180, 50, 50);
    Rectangle2D r = new Rectangle2D.Double(0, 0, 100, 100);
    g2.fill(r);
    g2.dispose();
}