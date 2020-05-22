import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
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

public class MouseOverTest {

    public static void main(String[] args) {
        new MouseOverTest();
    }

    public MouseOverTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    BufferedImage background = ImageIO.read(new File("C:\\hold\\thumbnails\\_MTCGAC__Pulling_Cords_by_Dispozition.png"));

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new TestPane(background));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public static class TestPane extends JPanel {

        protected static final Color BLUE_FILTER = new Color(0, 0, 255, 38);

        private BufferedImage background;
        private Rectangle imageBounds;
        private boolean mouseInTheHouse;

        public TestPane(BufferedImage background) {
            this.background = background;
            MouseAdapter ma = new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    mouseInTheHouse = getImageBounds().contains(e.getPoint());
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mouseInTheHouse = false;
                    repaint();
                }

            };
            addMouseMotionListener(ma);
            addMouseListener(ma);
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? new Dimension(200, 200) : new Dimension(background.getWidth(), background.getHeight());
        }

        @Override
        public void invalidate() {
            imageBounds = null;
            super.invalidate();
        }

        protected Rectangle getImageBounds() {

            if (imageBounds == null) {

                if (background != null) {

                    int x = (getWidth() - background.getWidth()) / 2;
                    int y = (getHeight() - background.getHeight()) / 2;
                    imageBounds = new Rectangle(x, y, background.getWidth(), background.getHeight());

                } else {

                    imageBounds = new Rectangle(0, 0, 0, 0);

                }

            }

            return imageBounds;

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Rectangle bounds = getImageBounds();
            if (background != null) {
                g2d.drawImage(background, bounds.x, bounds.y, this);
            }
            if (mouseInTheHouse) {
                g2d.setColor(BLUE_FILTER);
                g2d.fill(bounds);
            }
            g2d.dispose();
        }

    }

}