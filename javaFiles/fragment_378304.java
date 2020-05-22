import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;

public class Test extends JFrame implements MouseWheelListener {

    private static final long serialVersionUID = 1L;
    private JPanel p;

    public Test() {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1000, 1000));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        p = new JPanel();
        p.setPreferredSize(new Dimension(200, 200));
        p.setBackground(Color.red);
        add(p);
        addMouseWheelListener(this);
        pack();
        setVisible(true);
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        Dimension dim100 = new Dimension(100, 100);
        Dimension dim200 = new Dimension(200, 200);
        System.out.println(p.getSize());
        if (p.getPreferredSize().equals(dim100)) {
            p.setPreferredSize(dim200);
            p.revalidate();
            System.out.println(p.getSize());
        } else if (p.getPreferredSize().equals(dim200)) {
            p.setPreferredSize(dim100);
            p.revalidate();
            System.out.println(p.getSize());
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test();
            }
        });
    }
}