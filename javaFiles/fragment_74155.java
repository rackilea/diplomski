String s = "S"; // always a single character!
Rectangle rect = getRect(); // defines the desired size and position
FontMetrics fm = g2d.getFontMetrics();
FontRenderContext frc = g2d.getFontRenderContext();
TextLayout tl = new TextLayout(s, g2d.getFont(), frc);
AffineTransform transform = new AffineTransform();
transform.setToTranslation(rect.getX(), rect.getY());
double scaleY = 
   rect.getHeight() / (double) (tl.getOutline(null).getBounds().getMaxY() 
                                - tl.getOutline(null).getBounds().getMinY());
transform.scale(rect.getWidth() / (double) fm.stringWidth(s), scaleY);
Shape shape = tl.getOutline(transform);
g2d.setClip(shape);
g2d.fill(shape.getBounds());