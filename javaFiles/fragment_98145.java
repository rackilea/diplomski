import java.awt.event.*;

public class Input implements KeyListener
{
    public boolean key_down = false;
    public boolean key_up = false;
    public boolean key_right = false;
    public boolean key_left = false;

    public void keyTyped(KeyEvent e) {
    }

    /** Here we have a rather basic key listener
     *  It is set that you can only go left right up or down right now
     *  If more directions are needed delete the "other key = false"
     */

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            key_right = true;
            key_left = false;
            key_up = false;
            key_down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            key_right = false;
            key_left = true;
            key_up = false;
            key_down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            key_right = false;
            key_left = false;
            key_up = true;
            key_down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            key_right = false;
            key_left = false;
            key_up = false;
            key_down = true;
        }
    }





    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            key_right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            key_left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            key_up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
           key_down = false;
        }
    }
}