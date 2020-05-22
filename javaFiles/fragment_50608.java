import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MoveTowards {

    public static void main(String[] args) {
        new MoveTowards();
    }

    public MoveTowards() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MoveTowardsPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    class MoveTowardsPane extends JPanel {

        private final BufferedImage image;
        private Point imagePosition = new Point(150, 150);
        private Point mousePoint;
        private double imageAngleRad = 0;

        public MoveTowardsPane() {
            BufferedImage i = null;
            try {
                i = ImageIO.read(getClass().getResource("/sprite.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            image = i;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mousePoint = e.getPoint();
                    double dx = e.getX() - imagePosition.getX();
                    double dy = e.getY() - imagePosition.getY();
                    imageAngleRad = Math.atan2(dy, dx);

                    repaint();
                }
            });

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (mousePoint != null) {

                        int centerX = imagePosition.x + (image.getWidth() / 2);
                        int centerY = imagePosition.y + (image.getHeight() / 2);

                        if (mousePoint.x != centerX) {
                            imagePosition.x += mousePoint.x < centerX ? -1 : 1;
                        }
                        if (mousePoint.y != centerY) {
                            imagePosition.y += mousePoint.y < centerY ? -1 : 1;
                        }
                        repaint();
                    }
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics gr) {
            super.paintComponent(gr);
            Graphics2D g = (Graphics2D) gr.create();
            g.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

            int cx = image.getWidth() / 2;
            int cy = image.getHeight() / 2;
            AffineTransform oldAT = g.getTransform();
            g.translate(cx + imagePosition.x, cy + imagePosition.y);
            g.rotate(imageAngleRad);
            g.translate(-cx, -cy);
            g.drawImage(image, 0, 0, null);
            g.setTransform(oldAT);
            g.dispose();

        }

    }
}