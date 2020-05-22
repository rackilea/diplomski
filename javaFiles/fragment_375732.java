import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Repainter extends JPanel {
    private Point topLeft;
    private int increamentX = 5;

    public Repainter() {
        topLeft = new Point(100, 100);
    }

    public void move() {
        topLeft.x += increamentX;
        if (topLeft.x >= 200 || topLeft.x <= 100) {
            increamentX = -increamentX;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(topLeft.x, topLeft.y, 100, 100);
    }

    public void startAnimation() {
        SwingWorker<Object, Object> sw = new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {
                while (true) {
                    move();
                    Thread.sleep(100);
                }
            }
        };

        sw.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Repaint Demo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);

                Repainter repainter = new Repainter();

                frame.add(repainter);

                repainter.startAnimation();
                frame.setVisible(true);
            }
        });
    }
}