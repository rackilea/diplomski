private init(){
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();
    // then draw your grid into g
}

public void paint(Graphics g) {
    g.drawImage(image, 0, 0, null);
    // then draw the graphs
}