public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    rotation.setToTranslation(500, 200);
    rotation.rotate(angle, 32, 32);
    rect1 = new Rectangle(0, 0, 64, 64);
    path = new Path2D.Double(rect1, rotation);
    double r = 32.0 * Math.sqrt(2);
    // (532, 232) - coordinates of rectangle center        |
    // you can change position of second rectangle by this V substraction (all you need to know is that the full circle corresponds to 2Pi)
    int x2 = (int) Math.round(532 + r * Math.cos(angle - Math.PI / 4));
    int y2 = (int) Math.round(232 + r * Math.sin(angle - Math.PI / 4));
    rect2 = new Rectangle(x2, y2, 10, 50);
    g2d.fill(path);
    g2d.fill(rect2);
}