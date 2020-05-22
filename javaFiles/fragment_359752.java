private static final float MIN_BLUE_HUE = 0.5f; // CYAN
private static final float MAX_BLUE_HUE = 0.8333333f; // MAGENTA

public static boolean isBlue(Color c) {
  float[] hsv = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
  float hue = hsv[0];
  if (hue >= MIN_BLUE_HUE && hue <= MAX_BLUE_HUE){
    return true;
  } 
  return false;
}