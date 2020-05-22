public void paintComponent(Graphics g) {
    super.paintComponent(g); // add this line

    this.g2 = (Graphics2D) g;
    g2.drawRect(x, y, width, height);

}