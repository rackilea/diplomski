@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (img != null) {
        g.drawImage(img, 0, 0, this);
    }
}