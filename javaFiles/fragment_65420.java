public void keyPressed(KeyEvent e)
{
    int key = e.getKeyCode();

    if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
    {
        isRight = true; //if the key is pressed
        p.setVelX(5);
    }
    else if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
    {
        isLeft = true; //if the key is pressed
        p.setVelX(-5);
    }

}

public void keyReleased(KeyEvent e)
{
    int key = e.getKeyCode();

    if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
    {
        isRight = false;
        if(!isLeft) p.setVelX(0); //if you are not going the other direction stop
    }

}