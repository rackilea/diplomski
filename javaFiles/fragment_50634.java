double x = (getWidth() - arrow.getBounds().getWidth()) / 2d;
double y = (getHeight() - arrow.getBounds().getHeight()) / 2d;

AffineTransform at = new AffineTransform();
at.translate(x, y);
at.rotate(theta, arrow.getBounds().getWidth() / 2d, arrow.getBounds().getHeight() / 2d);
g2d.setTransform(at);

g2d.draw(arrow);