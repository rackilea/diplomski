public Board() {
         this.setBackground(Color.GREEN);
  }

  public void paintComponent(Graphics g) 
{
    super.paintComponent(g);
    int width = getWidth();
    int height = getHeight();        

    g.setColor(Color.BLACK);
    g.drawOval(0, 0, width, height);
}