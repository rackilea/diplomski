int  pixel = src.pixels[row][col];
int  red = (pixel & 0x00ff0000) >> 16;
int  green = (pixel & 0x0000ff00) >> 8;
int  blue = pixel & 0x000000ff;
// and the Java Color is ...
Color color = new Color(red,green,blue);