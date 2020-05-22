private int xx;
private int yy;
private Color c;

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if(c != null) {
        int width=panel.getWidth()/x;
        int height=panel.getHeight()/y;

        g.setColor(c);

        g.drawRect(xx*width, yy*height, width, height);
        g.fillRect(xx*width, yy*height, width, height);
    }
}

public void write(int xx, int yy, Color c) {
    this.xx = xx;
    this.yy = yy;
    this.c = c;
    repaint();
}