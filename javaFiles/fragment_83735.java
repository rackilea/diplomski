import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Test extends JPanel {
    boolean circle = false;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        if (circle) {
            g.drawRect(150, 150, 100, 100);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(400, 400);

        final Test test = new Test();
        test.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                test.circle = true;
                test.repaint();
            }
        });
        f.add(test);
    }
}