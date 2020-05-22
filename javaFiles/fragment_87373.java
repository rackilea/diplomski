BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
copy.setData(image.getRaster()); // getRaster() is faster than getData(), as no copy is created

for (int x = 0; x < colors.length; x++) {
    Color color = new Color(copy.getRGB(x, 0), true);
    System.out.println(color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + color.getAlpha());
}