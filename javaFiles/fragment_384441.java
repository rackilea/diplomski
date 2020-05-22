import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class DrawShapes extends JFrame {
    private ShapePanel shape;

    public DrawShapes() {
        super("Random shapes");
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(shape = new ShapePanel(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        initTimer();
    }

    private void initTimer() {
        Timer t = new Timer(1500, e -> {
            shape.randomizeXY();
            shape.repaint();
        });
        t.start();
    }

    public static class ShapePanel extends JPanel {
        private int x, y;

        public ShapePanel() {
            randomizeXY();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillOval(x, y, 10, 10);
        }

        public void randomizeXY() {
            x = (int) (Math.random() * 500);
            y = (int) (Math.random() * 500);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawShapes().setVisible(true));
    }
}