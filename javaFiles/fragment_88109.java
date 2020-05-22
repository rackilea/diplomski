public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setColor(Color.black);
    g2d.fill(circle);

}//end paintComponent