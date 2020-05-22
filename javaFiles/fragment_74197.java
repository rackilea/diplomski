public void paint(Graphics g)
{
    super.paint(g);
    Color c = g.getColor();
    g.setColor( Color.black);
    g.fillOval(10,20,10,10);
    g.setColor(c);
    g.fillOval(40,20,10,10);
    //super.fillOval(10,10,40,35);
    g.fillOval(10,10,40,40);
}