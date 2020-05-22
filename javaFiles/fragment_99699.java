public void keyPressed(KeyEvent e)                  // #4A
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
    }

    x = Math.max(0, x);
    x = Math.min(SCREEN_WIDTH, x + radius);
    y = Math.max(0, y + radius);
    y = Math.min(SCREEN_HEIGHT, y);
    repaint();
}