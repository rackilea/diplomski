@Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    AffineTransform origX = g2d.getTransform();
    AffineTransform newX = (AffineTransform) origX.clone();
    newX.rotate(Math.toRadians(angle), this.getWidth() / 2, this.getHeight() / 2);  // Rotate from the center of screen
    newX.rotate(Math.toRadians(angle), x, y + 65);   // Rotate from the center of the shape
    g2d.setTransform(newX);
    g2d.setColor(Color.red);
    g2d.fillPolygon(starX, starY, 5);
    g2d.dispose();
    g.dispose();
  }