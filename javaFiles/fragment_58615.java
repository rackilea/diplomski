@Override
protected void paintComponent(Graphics gr){
    super.paintComponent(gr);
    Graphics2D g = (Graphics2D)gr;
    AffineTransform prevTransform = g.getTransform();
    AffineTransform at = new AffineTransform(prevTransform);
    at.scale(scale, scale); 
    g.setTransform(at);
    g.drawRect(...);
    g.setTransform(prevTransform); 
}