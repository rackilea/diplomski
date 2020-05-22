import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private double zoom = 1d;
        private BufferedImage img;

        public TestPane() {
            try {
                img = ImageIO.read(new File("..."));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            addMouseWheelListener(new MouseAdapter() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    if (e.getPreciseWheelRotation() < 0) {
                        zoom -= 0.1;
                    } else {
                        zoom += 0.1;
                    }
//                  zoom += e.getPreciseWheelRotation();
                    if (zoom < 0.01) {
                        zoom = 0.01;
                    }

                    repaint();

                }
            });
        }

        public String format(double value) {
            return NumberFormat.getNumberInstance().format(value);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            double width = getWidth();
            double height = getHeight();

            double zoomWidth = width * zoom;
            double zoomHeight = height * zoom;

            double anchorx = (width - zoomWidth) / 2;
            double anchory = (height - zoomHeight) / 2;

            AffineTransform at = new AffineTransform();
            at.translate(anchorx, anchory);
            at.scale(zoom, zoom);
            at.translate(-100, -100);

            g2d.setTransform(at);
            g2d.drawImage(img, 0, 0, this);

            g2d.dispose();
        }

    }

}