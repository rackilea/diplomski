public void paint(Graphics g){
    // Broken here...
    Graphics2D graph2 = (Graphics2D)g;

    Shape Rect = new Rectangle2D.Float(x, 50, 50, 30);
    graph2.setColor(Color.RED);
    graph2.fill(Rect);
    tm.start();

}