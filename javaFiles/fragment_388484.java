private static final Font font = new Font("Monospaced", Font.PLAIN, 32);
private static final String s = "12:34";
...
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setFont(font);
    int xx = this.getWidth();
    int yy = this.getHeight();
    int w2 = g.getFontMetrics().stringWidth(s) / 2;
    int h2 = g.getFontMetrics().getDescent();
    g.setColor(Color.green);
    g.drawString(s, xx / 2 - w2, yy / 2 + h2);
}