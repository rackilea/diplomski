import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Simple Canvas with KeyListener
 */
public class TestCanvas extends Canvas implements KeyListener, Runnable {

    public TestCanvas() {
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Do Stuff    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Do Stuff
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Do Stuff
    }
}