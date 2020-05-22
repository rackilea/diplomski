/**
 * Renders a string to a translucent image and returns it
 * @param string the text, like "Hello World"
 * @param size an enum, like SMALL, MIDDLE, LARGE
 * @param graphics the graphics of the scene, used for measuring the string-dimension
 * @return
 */
public BufferedImage renderTextToImage(String string, Size size, Color color, Graphics graphics) {
    Vector2 imageDimension = this.getFontDimensionPixels(string, size, graphics); // helper which measures string using fontmetrics
    BufferedImage returnImage = new BufferedImage(
            Max.maxInt((int)imageDimension.getX(), 1), // Max.maxInt() is a little helper to get the bigger out of two values
            Max.maxInt((int)imageDimension.getY(), 1),
            Transparency.TRANSLUCENT);
    Graphics2D returnGraphics = returnImage.createGraphics();
    returnGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    returnGraphics.setFont(this.getFont(size));
    returnGraphics.setColor(color);
    returnGraphics.drawString(string, 0, returnImage.getHeight() * 0.8f);
    returnGraphics.dispose();
    return returnImage;
}