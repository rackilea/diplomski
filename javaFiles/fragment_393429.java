JPanel panel = new JPanel() {
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawLine(30,100,270,100);
    g.drawLine(30,200,270,200);
    g.drawLine(100,35,100,250);
    g.drawLine(200,35,200,250);   
  }
};