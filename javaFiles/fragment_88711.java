public void mouseDragged(MouseEvent e) 
{
   mosX = e.getX();
   mosY = e.getY();
   repaint(); //NOT paint(g);
}

//...
public void paint(Graphics g) 
{
    //draw on the canvas not on the component 
    //since the canvas gets drawn over it
    Graphics g2 = myCanvas.getGraphics();
    g2.setColor(Color.green);
    g2.fillOval(mosX, mosY, 30, 30);
}