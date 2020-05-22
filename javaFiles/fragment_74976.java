public boolean isShadeOfWhite(BufferedImage img, int x, int y){
Color color = new Color(img.getRGB(x, y));
int imgR = color.getRed();
int imgG = color.getGreen();
int imgB = color.getBlue();

if(imgR == imgG && imgR == imgB){
    return true;
}
    return false;
}