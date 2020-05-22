import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageFrame {
    private final JFrame frame = new JFrame();
    public ImageFrame() {
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.add(new BackGroundPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class BackGroundPanel extends JPanel {

        BufferedImage image;
        int pX, pY;

        public BackGroundPanel() {
            try {
                image = ImageIO.read(new URL("http://i.stack.imgur.com/efS42.png"));
            } catch (IOException ex) {
                Logger.getLogger(ImageFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            setOpaque(false);

            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    // Get x,y and store them
                    pX = me.getX();
                    pY = me.getY();
                }
            });
            addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent me) {
                    frame.setLocation(frame.getLocation().x + me.getX() - pX, 
                            frame.getLocation().y + me.getY() - pY);
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return image == null ? new Dimension(300, 300) : new Dimension(image.getWidth(), image.getHeight());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageFrame();
            }
        });
    }
}