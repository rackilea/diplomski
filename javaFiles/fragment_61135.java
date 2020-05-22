@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(0, 0, 0, 0.5f));
    g.fillRect(this.x, this.y, this.width, this.height);
}