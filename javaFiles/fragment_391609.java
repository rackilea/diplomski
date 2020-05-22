AffineTransform reset = new AffineTransform();
reset.rotate(0, 0, 0);
Graphics2D g2 = (Graphics2D)g;
g2.rotate(angle, player.x, player.y);
//draw the image here
g2.setTransform(reset);