@Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g); 
    Graphics2D graphics2D = (Graphics2D) g;

    //Set  anti-alias!
    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON); 

   // Set anti-alias for text
    graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 

    graphics2D.setColor(Color.red);
    graphics2D.drawString("Hello world", 10, 10);
}