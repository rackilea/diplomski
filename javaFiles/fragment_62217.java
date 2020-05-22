import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class JInternalFrame extends JFrame implements KeyListener {

    public JInternalFrame() 
    {
        super();


        // other stuff to add to frame
        this.setSize(400, 400);
        this.setVisible(true);

        this.addKeyListener( this );
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Don't need to implement this


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if( e.getKeyCode() == KeyEvent.VK_ESCAPE ) {
            System.exit(0); //Change this to dispose or whatever you want to do with the frame
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Dont need to implement anything here

    }

    public static void main(String[] args)
    {
        JInternalFrame frame = new JInternalFrame();
    }

}