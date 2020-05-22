package stackoverflowanswer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MouseListenerApp{
public static void main(String[] args) {        
    Runnable r = new Runnable(){
        @Override
        public void run() {
            JFrame frame = new JFrame("mouselistener"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println(e.getButton());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });

            frame.setSize(200,200);
            frame.setVisible(true);
        }
    };

    SwingUtilities.invokeLater(r);
    }
}