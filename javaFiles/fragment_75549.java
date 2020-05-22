private int lastX;
private int lastY;

public void drawPlayer(Graphics g)
{
    g.clearRect(40*lastX, 40*lastY, 40, 40);
    g.setColor(new Color(0,0,0));
    g.fillRect(40*x, 40*y, 40, 40);
    lastX = x;
    lastY = y;
}