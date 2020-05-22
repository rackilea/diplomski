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
        p.setPreferredSize(new Dimension(900, 900));
        p.setBackground(Color.red);
        add(p);
        addMouseWheelListener(this);
        pack();
        setVisible(true);
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        Dimension dim100 = p.getSize();
        System.out.println("before "+ p.getSize());
        p.setPreferredSize(new Dimension(dim100.height - 5, dim100.width - 5));
        p.revalidate();
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                System.out.println("after "+ p.getSize());
            }
        });
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