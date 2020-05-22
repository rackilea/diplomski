@Override
public void render(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.red);
    g2d.rotate(this.angle);
    g2d.fill(this);
    g2d.draw(this);
    this.render(g);
}