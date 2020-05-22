import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Example {

    public static void main(String[] args) {
        new Example();
    }

    public Example() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
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
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;
        private Rectangle drawRectangle;
        private boolean highlight = false;

        public TestPane() throws IOException {
            img = ImageIO.read(...);
            addMouseMotionListener(new MouseAdapter() {

                @Override
                public void mouseMoved(MouseEvent e) {
                    highlight = drawRectangle.contains(e.getPoint());
                    repaint();
                }

            });

            int width = getPreferredSize().width;
            int height = getPreferredSize().height;

            int x = (width - img.getWidth()) / 2;
            int y = (height - img.getHeight()) / 2;

            drawRectangle = new Rectangle(x, y, img.getWidth(), img.getHeight());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(img, drawRectangle.x, drawRectangle.y, this);
            if (highlight) {
                g2d.setColor(Color.RED);
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                g2d.fill(drawRectangle);
            }
            g2d.dispose();
        }

    }

}