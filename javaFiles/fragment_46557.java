import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShearTest {

    public static void main(String[] args) {
        new ShearTest();
    }

    public ShearTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;

        private float xScale = 1f;
        private float xDelta = 0.05f;

        public TestPane() {

            try {
                img = ImageIO.read(new File("C:\\hold\\thumbnails\\megatokyo.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            final Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xScale += xDelta;
                    if (xScale > 1) {
                        xDelta *= -1;
                    } else if (xScale < -1) {
                        xDelta *= -1;
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Graphics2D g2d = (Graphics2D) g.create();

                int x = (int)((getWidth() - (img.getWidth() * xScale)) / 2);
                int y = (getHeight() - img.getHeight()) / 2;

                AffineTransform at = new AffineTransform();
                at.translate(x, y);
                at.scale(xScale, 1);

                g2d.setTransform(at);
                g2d.drawImage(img, 0, 0, this);

                g2d.dispose();
            }
        }
    }
}