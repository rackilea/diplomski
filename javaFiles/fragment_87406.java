public static BufferedImage addTextWatermark(String text, BufferedImage sourceImage) {
 Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();

 // initializes necessary graphic properties
 AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
 g2d.setComposite(alphaChannel);
 g2d.setColor(Color.WHITE);
 g2d.setFont(new Font("Arial", Font.BOLD, 64));
 FontMetrics fontMetrics = g2d.getFontMetrics();
 Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);

 // calculates the coordinate where the String is painted
 int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
 int centerY = sourceImage.getHeight() / 2;

 // paints the textual watermark
 g2d.drawString(text, centerX, centerY);

 return sourceImage;
}