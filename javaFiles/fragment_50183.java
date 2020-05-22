img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
g2d = img.createGraphics();
//...
g2d.setColor(Color.WHITE);
g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
g2d.setColor(Color.BLACK);
g2d.drawString(text, 0, fm.getAscent());
g2d.dispose();
try {
    ImageIO.write(img, "png", new File("Text.png"));
} catch (IOException ex) {
    ex.printStackTrace();
}