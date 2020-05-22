public void paintComponent(Graphics g) {
  super.paintComponent(g);

  Graphics2D g2d = (Graphics2D) g.create();
  g2d.setColor(getColor());
  g2d.fillRect(x, y, 4, 4);

}