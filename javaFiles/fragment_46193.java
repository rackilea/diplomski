private Image image;
AffineTransform identity = new AffineTransform();

Graphics2D g2d = (Graphics2D)g;
AffineTransform trans = new AffineTransform();
trans.setTransform(identity);
trans.rotate( Math.toRadians(45) );
g2d.drawImage(image, trans, this);