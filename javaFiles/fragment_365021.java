private Color currentColor;

...

public void paint(Graphics g)
{
    g.setColor(Color.white);
    g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

    g.setColor(currrentColor);
    g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
}

...

public void keyPressed(KeyEvent e)                  
{
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_LEFT)
    {
        x = x - STEP_SIZE;
    }
    else if (keyCode == KeyEvent.VK_RIGHT)
    {
        x = x + STEP_SIZE;
    }
    else if (keyCode == KeyEvent.VK_UP)
    {
        y = y - STEP_SIZE;
    }
    else if (keyCode == KeyEvent.VK_DOWN)
    {
        y = y + STEP_SIZE;
    }else currentColor = Color.BLUE;
    repaint();
}