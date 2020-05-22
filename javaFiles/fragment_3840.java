protected void draw(Graphics2D g2d, Color boxColor, Color lineColor) {
    g2d.setColor(boxColor);
    g2d.fill(box);
    g2d.setColor(lineColor);
    g2d.drawLine(0, 0, getWidth(), getHeight());
}