int scaledWidth = (int)(sf*o.width);
int scaledHeight = (int)(sf*o.height);
PImage out = createImage(scaledWidth, scaledHeight, RGB);
o.loadPixels();
out.loadPixels();
for (int i = 0; i < scaledHeight; i++) {
  for (int j = 0; j < scaledWidth; j++) {
    int y = Math.min( round(i / sf), o.height ) * o.width;
    int x = Math.min( round(j / sf), o.width );
    out.pixels[(int)((scaledWidth * i) + j)] = o.pixels[(y + x)];
  }
}