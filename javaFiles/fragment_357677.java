int deg = 0;
while ( deg <= 360 ) {
  x = middle + (int)(Math.cos(deg)*radius);
  y = middle + (int)(Math.sin(deg)*radius);
  panel.drawNextPixel(x, y);
  deg++;
}