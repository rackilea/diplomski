public void paintComponent(Graphics g){
  super.paintComponent(g);
  Graphics2D gui = (Graphics2D) g;
  Rectangle2D rectangle = new Rectangle2D.Double(x,y,100,150);
  gui.setPaint(Color.GREEN);
  gui.fill(rectangle);
  //time.start();
}