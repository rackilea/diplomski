@Override
public void keyPressed(KeyEvent e)
{
    //Previous code


    if(e.getKeyCode() == KeyEvent.VK_CONTROL)
    {
        ctrlPressed = true;
    }
}

@Override
public void keyReleased(KeyEvent e)
{
    //Previous code


    if(e.getKeyCode() == KeyEvent.VK_CONTROL)
    {
        ctrlPressed = false;
    }
}