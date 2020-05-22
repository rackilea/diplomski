import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test1 extends JFrame {

    public Test1() {
        initUI();
    }

    private void initUI() {
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setBackground(Color.black);

        JButton b = new JButton("test");
        b.addMouseListener(new Controller());
        container.add(b);

        add(container);
        pack();

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Test1 c = new Test1();
                c.setVisible(true);
            }
        });
    }

    class Controller extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent me) {
            System.out.println("oh, it arrived");
        }
    }

}