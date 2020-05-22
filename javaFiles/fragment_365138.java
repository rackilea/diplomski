public void paint(Graphics g)
{
    super.paint(g); // always call the parent method 1st..
    Graphics2D g2 = (Graphics2D)g;
    g2.fill(rect);
}