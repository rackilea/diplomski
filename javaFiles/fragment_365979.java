import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * @see https://stackoverflow.com/a/9858355/230513
 * @see https://stackoverflow.com/a/3538279/230513
 */
public class SwingPaint {

    private static final int N = 4;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setLayout(new GridLayout(N, N));
                for (int i = 0; i < N * N; i++) {
                    frame.add(new CirclePanel());
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private static class CirclePanel extends JPanel {

        private static final Random r = new Random();

        public CirclePanel() {
            this.setPreferredSize(new Dimension(80, 80));
            this.setForeground(new Color(r.nextInt()));
            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    CirclePanel.this.update();
                }
            });
        }

        public void update() {
            this.setForeground(new Color(r.nextInt()));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension size = this.getSize();
            int d = Math.min(size.width, size.height) - 10;
            int x = (size.width - d) / 2;
            int y = (size.height - d) / 2;
            g.fillOval(x, y, d, d);
            g.setColor(Color.blue);
            g.drawOval(x, y, d, d);
        }
    }
}