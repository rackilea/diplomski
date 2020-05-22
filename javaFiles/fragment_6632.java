@Override
public void keyTyped(KeyEvent e)
{
    if(e.getKeyCode() == KeyEvent.VK_Q && ctrlPressed)
    System.exit(0);
}