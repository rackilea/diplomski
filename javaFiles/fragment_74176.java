public void paint(Graphics g)
{
  g.setColor(Color.BLACK);                    // clear the frame ...
  g.fillRect(0, 0, getWidth(), getHeight());

  if (bouncing) 
  {
    g.setColor(Color.blue);
    g.drawOval(x, y, 10, 10);
  }
}