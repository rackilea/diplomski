public static BufferedImage generateAndWriteToImage(String string, int x, int y) {

    BufferedImage image = new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setPaintMode();
    g.setFont(g.getFont().deriveFont(30f));
    g.drawString(string, 100, 100);
    g.dispose();
    return image;
}