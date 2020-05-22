import java.awt.*;

public class RulerExample {

    public static void main(String args[]) {
        JFrame f = new JFrame();
        f.add(new JComponent() {

            private final double TICK_DIST = 20;

            void drawRuler(Graphics g1, int x1, int y1, int x2, int y2) {
                Graphics2D g = (Graphics2D) g1.create();

                double dx = x2 - x1, dy = y2 - y1;
                double len = Math.sqrt(dx*dx + dy*dy);
                AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
                at.concatenate(AffineTransform.getRotateInstance(Math.atan2(dy, dx)));
                g.transform(at);

                // Draw horizontal ruler starting in (0, 0)
                g.drawLine(0, 0, (int) len, 0);
                for (double i = 0; i < len; i += TICK_DIST)
                    g.drawLine((int) i, -3, (int) i, 3);
            }

            public void paintComponent(Graphics g) {
                drawRuler(g, 10, 30, 300, 150);
                drawRuler(g, 300, 150, 100, 100);
                drawRuler(g, 100, 100, 120, 350);
                drawRuler(g, 50, 350, 350, 50);
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setVisible(true);
    }
}