@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics g2d = (Graphics2D) g.create();
    FontMetrics fm = g2d.getFontMetrics();
    g2d.drawString("Hello", 0, 0);
    g2d.drawString("Hello", fm.stringWidth("Hello"), fm.getAscent());
    g2d.dispose();
}