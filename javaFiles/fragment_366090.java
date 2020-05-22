@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    // Backup original transform
    AffineTransform originalTransform = g2d.getTransform();

    g2d.translate(panX, panY);
    g2d.scale(zoom, zoom);

    // paint the image here with no scaling
    g2d.drawImage(img, 0, 0, null);

    // Restore original transform
    g2d.setTransform(originalTransform);
}