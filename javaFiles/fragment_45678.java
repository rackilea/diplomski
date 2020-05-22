@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, 0, 0, getWidth(), getHeight(), this); 
    // img is the BufferedImage in the first code.
}