import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame {

    private static final int W = 800;
    private static final int H = 400;

    public Main() {
        super("JFrame");
        this.add(new ImagePanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setSize(W, H);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main();
            }
        });
    }

    class ImagePanel extends JPanel {

        Timer movementTimer;
        int x, y;

        public ImagePanel() {
            x = 0;
            y = 0;
            movementTimer = new Timer(12, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    moveImage();
                    repaint();
                }
            });
            movementTimer.start();
        }

        public void moveImage() {
            x++;
            y++;
            if (x > W) {
                x = 0;
            }
            if (y > H) {
                y = 0;
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            long start = System.nanoTime();
            g.setColor(Color.RED);
            g.fillRect(0, 0, W, H);
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 50, 50);
            double delta = (System.nanoTime() - start) / 1000000d;
            g.drawString(String.format("%1$5.3f", delta), 5, 15);
        }
    }
}