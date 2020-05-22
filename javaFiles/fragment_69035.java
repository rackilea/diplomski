// 100x100 is the desired bounding box of the scaled area
// Change this for the actual area you want to use
int x = (100 - scaled.getWidth()) / 2;
int y = (100 - scaled.getHeight()) / 2;
g2d.drawImage(scaled, x, y, null);
g2d.dispose();