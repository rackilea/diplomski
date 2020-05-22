import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestClip {

    public static void main(String[] args) {
        new TestClip();
    }

    public TestClip() {
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
        private BufferedImage layer;

        public TestPane() {
            setBackground(Color.BLACK);
            try {
                img = ImageIO.read(new File("Lurk.png"));
                layer = new BufferedImage(199, 199, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = layer.createGraphics();
                g2d.drawImage(img, 
                        layer.getWidth() - (img.getWidth() / 2), 
                        (layer.getHeight() - img.getHeight()) / 2, 
                        this);
                g2d.dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.drawRect(100, 100, 200, 200);
            g2d.drawImage(layer, 101, 101, this);
//            g2d.setClip(101, 101, 199, 199);
//            g2d.drawImage(img, 300 - (img.getWidth() / 2), (getHeight() - img.getHeight()) / 2, this);
            g2d.dispose();
        }
    }

}