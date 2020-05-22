private void scaledDrawing(Graphics g, float scale){
   Graphics2D g2 = (Graphics2D) g;
   AffineTransform at = new AffineTransform();
   AffineTransform save = g2.getTransform();
   at.setToIdentity();
   at.scale(goa.getScale().x, goa.getScale().y);
   g2.transform(at);
   image.paintIcon(c, g2);
   g2.setTransform(save);
}