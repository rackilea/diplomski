import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

public class Graphics2DTest extends JPanel implements ActionListener {
    private Timer time = new Timer(5, (ActionListener) this);
    int x = 0, y = 0;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gui = (Graphics2D) g;
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, 100, 150);
        gui.setPaint(Color.GREEN);
        gui.fill(rectangle);
        //time.start();
    }

    public void actionPerformed(ActionEvent arg0) {
        x++;
        y++;
        repaint();
    }

    public Graphics2DTest() {
        setPreferredSize(new Dimension(700, 500));
        time.start();
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Graphics2DTest");
        frame.getContentPane().add(new Graphics2DTest());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}