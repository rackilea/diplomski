@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // This is bad...
    //this.setOpaque(true);
    // This is bad...
    //this.setBackground(Color.WHITE);
    Graphics2D g2 = (Graphics2D) g;
    for (Rectangle rect : squares) {
        g2.draw(rect);
    }
}