public void draw(Graphics g) {
    this.g = g;
    Graphics2D g2 = (Graphics2D) g;

    AffineTransform at = new AffineTransform();
    Rectangle rect = this.getBounds();
    at.rotate(Math.toRadians(rotationAngle), rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);
    g2.setColor(Color.BLUE);
    g2.draw(at.createTransformedShape(this));

}