int red = ...;
int green = ...;
int blue = ...;

float[] hsb = Color.RGBtoHSB(red, green, blue, null);

float hue = hsb[0];
float saturation = hsb[1];
float brightness = hsb[2];

/* then change the saturation... */

int rgb = Color.HSBtoRGB(hue, saturation, brightness);

red = (rgb>>16)&0xFF;
green = (rgb>>8)&0xFF;
blue = rgb&0xFF;