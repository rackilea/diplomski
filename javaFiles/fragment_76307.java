@Override
public void paint(final Graphics g) {
    super.paint(g);
    g.setColor(Color.red);
    g.fillOval(x, y, 50, 50);
    g.setColor(Color.blue);
    g.fillRect(200, 300, 100, 80);
    if (x > 180 || y > 280) {
        g.drawString("Target hit!!", 80, 20);

    }
}