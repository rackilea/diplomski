public void drawFace (Graphics g, int x, int y)
{
   g.setColor(Color.YELLOW);
   g.fillOval(x, y, 100, 100);
   g.setColor(Color.BLUE);
   g.fillOval(x + 25, y + 25, 20, 20);
   g.fillOval(x + 55, y + 25, 20, 20);
   g.setColor(Color.red);
   g.drawArc(x + 25, y + 50, 40, 40, 0, -180);
}