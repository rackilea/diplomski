BufferedImage img = null;
try {
    // Here set the path to your image
    img = ImageIO.read(new File("myIcon.png"));
} catch (IOException e) {}

ImageIcon icon = new ImageIcon(img);