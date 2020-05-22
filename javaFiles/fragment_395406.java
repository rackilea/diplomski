import toxi.color.*;
import toxi.geom.*;

void setup()
{
  size(600, 250);
  colorMode(RGB, 1, 1, 1);
  background(1);
  noStroke();
  translate(50, 50);

  // RGB: 10 rects where perceived contrast is NOT equal in all squares
  for(float i = 0; i < 10; i++)
  {
    fill(i / 10.0, i / 10.0, i / 10.0);
    rect(i * 50, 0, 50, 50);
  }

  // LAB: 10 rects where perceived contrast IS equal in all squares
  translate(0, 50);

  for(int i = 0; i < 10; i++)
  {
    float[] rgb = TColor.labToRGB(i * 10, 0, 0);
    TColor col = TColor.newRandom().setRGB(rgb);
    fill(col.toARGB());
    rect(i * 50, 0, 50, 50);
  }
}