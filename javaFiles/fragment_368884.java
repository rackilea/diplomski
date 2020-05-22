private final BasicStroke thin = new BasicStroke(1f);
private final BasicStroke thick = new BasicStroke(4f);

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.drawImage(image, 0, 0, this);
    for (Rectangle2D[] rects : imageGrid) {
        for (Rectangle2D rect : rects) {
            if (imageArea.contains(rect)) {
                g2.setStroke(thick);
                g2.setColor(Color.GREEN);
                g2.draw(rect);
            } else {
                g2.setStroke(thin);
                g2.setColor(Color.RED);
                g2.draw(rect);
            }
        }
    }
}