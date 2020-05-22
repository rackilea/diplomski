import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MouseAndJTextField {

    private JFrame fr = new JFrame();
    private JTextField jf = new JTextField(20);

    public MouseAndJTextField() {
        jf.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.out.println(jf.getMouseListeners().length);
            }
        });
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(jf);
        fr.pack();
        fr.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MouseAndJTextField fs = new MouseAndJTextField();
            }
        });
    }
}