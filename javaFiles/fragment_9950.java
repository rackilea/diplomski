public void rotateIMG(double d) {
    // Consider also using GraphicsConfiguration.createCompatibleImage().
    // I'm just putting here something that should work
    BufferedImage b = new BufferedImage(a.getHeight(), a.getWidth(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = b.createGraphics();

    g2d.rotate(Math.toRadians(d), a.getWidth()/2, a.getHeight()/2);
    // Note the a instead of b here
    g2d.drawImage(a, 0, 0, null);
    // Do you want to keep the old a or not?
    // a = b;
    ImageIcon rtimg = new ImageIcon(b);
    label.setIcon(rtimg);
}