import java.awt.event.*;
import javax.swing.JFrame;

public class ListenerTest extends JFrame implements WindowListener {

public static void main(String[] args) {
    ListenerTest frame = new ListenerTest();
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setVisible( true );
}

public ListenerTest() {
    this.addWindowListener( this );
}

public void windowActivated(WindowEvent e) {
    System.out.println(" activated ");
}
public void windowClosed(WindowEvent e){
    System.out.println(" closed ");
}
public void windowClosing(WindowEvent e){
    System.out.println(" closing ");
}
public void windowDeactivated(WindowEvent e){
    System.out.println(" deactivated ");
}
public void windowDeiconified(WindowEvent e){
    System.out.println(" deiconified ");
}
public void windowIconified(WindowEvent e){
    System.out.println(" iconified ");
}
public void windowOpened(WindowEvent e){
    System.out.println(" opened ");
}
}