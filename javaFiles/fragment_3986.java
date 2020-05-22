public void paint(Graphics2D g2d) {

    g2d.translate(x, y);
    g2d.setColor(new Color(0, 0, 192, 32));
    g2d.fill(areaOfEffect);
    g2d.setColor(color);
    g2d.fill(ball);
    g2d.translate(-x, -y);

}