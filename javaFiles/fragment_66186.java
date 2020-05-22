public void paintComponent(Graphics g) {
    // Let UI Delegate paint first, which 
    // includes background filling since 
    // this component is opaque.

    super.paintComponent(g);       
    g.drawString("This is my custom Panel!",10,20);
    redSquare.paintSquare(g);
}