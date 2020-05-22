Color getColor(double val, double min, double max) {
  int red = 100;
  int green = 100;
  int blue = val/(max-min) * 256;

  return new Color (red, green, blue);
}