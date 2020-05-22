public void process(int key)
{
    if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT)
    {
        moveLeft();
    }
    else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT)
    {
        moveRight();
    }
}