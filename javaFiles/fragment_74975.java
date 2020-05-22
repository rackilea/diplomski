public BufferedImage shadePixel(BufferedImage img, int x, int y, int darkness){
//x is the mouse x position & y is the mouse y position

Color color = new Color(img.getRGB(x, y));
int imgR = color.getRed()-darkness;//if it makes it brighter try + instead of -
int imgG = color.getGreen()-darkness;
int imgB = color.getBlue()-darkness;
Color color2 = new Color(imgR, imgG, imgB);

img.setRGB(x, y, color2.getRGB());

return img;
}