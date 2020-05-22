BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

Graphics2D g2d = copy.createGraphics();
g2d.setComposite(AlphaComposite.Src); // Completely replace, default is SrcOver
g2d.drawImage(image, 0, 0, null);
g2d.dispose();

for (int x = 0; x < colors.length; x++) {
    Color color = new Color(copy.getRGB(x, 0), true);
    System.out.println(color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + color.getAlpha());
}