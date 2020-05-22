import java.awt.Color; // added import
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

public class EnterExitListener extends JFrame
{
  public static void main(String [] args)
  {
    JFrame frame=new JFrame();
    final int FRAME_WIDTH=500;
    final int FRAME_HEIGHT=600;
    frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);   

    class MouseEnterExitListener implements MouseListener
    {
        public void mouseEntered(MouseEvent event)
        {
            System.out.println("ENTER");
            frame.setBackground(Color.BLUE);
        }
        public void mouseExited(MouseEvent event) // lowercase 'm'
        {
            System.out.println("EXIT");
            frame.setBackground(Color.RED);
        }  
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mousePressed(MouseEvent event) {} 
    } // moved closing bracket

    MouseListener listener = new MouseEnterExitListener(); // instantiate class, not interface
    frame.addMouseListener(listener);   
  }
}