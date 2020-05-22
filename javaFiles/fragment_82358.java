public void paintComponent(Graphics g) {
    super.paintComponent(g);

    //Image img = Toolkit.getDefaultToolkit().getImage(Rectangles2.class.getResource("background.jpg"));
    //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    Graphics2D g2 = (Graphics2D) g;

    for (Rectangle s : rectanglesList) {
        g2.setColor(bColor);
        g2.fill(s);
        g2.setColor(wColor);
        g2.draw(s);
    }
}