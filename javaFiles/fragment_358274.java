public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (DoubleBufferImage != null) {
        g.drawImage(DoubleBufferImage, 0, 0, null);
    }
}