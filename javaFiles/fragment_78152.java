public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for (Shape shape : shapes) {
        g2d.draw(shape); // !! added
    }
}