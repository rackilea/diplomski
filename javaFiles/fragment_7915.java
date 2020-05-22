public class MyKeyListener implements KeyListener, MouseListener{
   int direction = 0;

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()  == KeyEvent.VK_LEFT) direction = -1;
        else if(e.getKeyCode()  == KeyEvent.VK_RIGHT) direction = 1;
    }

    public void keyReleased(KeyEvent e) {
        direction = 0;
    }
}