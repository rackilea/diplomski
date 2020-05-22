import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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

public class MouseSelection {

    public static void main(String[] args) {
        new MouseSelection();
    }

    public MouseSelection() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                ImagePane imgPane = new ImagePane();
                new MouseHandler(imgPane);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(imgPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MouseHandler    extends MouseAdapter {

        private ImagePane imgPane;

        private Point clickPoint;

        public MouseHandler(ImagePane imgPane) {
            this.imgPane = imgPane;
            imgPane.addMouseMotionListener(this);
            imgPane.addMouseListener(this);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            imgPane.clearSelection();
            clickPoint = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            clickPoint = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (clickPoint != null) {
                Point dragPoint = e.getPoint();

                int x = Math.min(clickPoint.x, dragPoint.x);
                int y = Math.min(clickPoint.y, dragPoint.y);
                int width = Math.max(clickPoint.x, dragPoint.x) - x;
                int height = Math.max(clickPoint.y, dragPoint.y) - y;

                imgPane.setSelection(new Rectangle(x, y, width, height));

            }
        }

    }

    public class ImagePane extends JPanel {

        private BufferedImage img;
        private Rectangle selection;

        public ImagePane() {
            try {
                img = ImageIO.read(new File("C:\\hold\\thumbnails\\issue459.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (img != null) {
                int x = (getWidth() - img.getWidth()) / 2;
                int y = (getHeight() - img.getHeight()) / 2;
                g2d.drawImage(img, x, y, this);
            }
            if (selection != null) {

                Color color = UIManager.getColor("Table.selectionBackground");
                g2d.setColor(color);
                Composite comp = g2d.getComposite();
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                g2d.fill(selection);
                g2d.setComposite(comp);
                g2d.draw(selection);

            }
            g2d.dispose();
        }

        protected void clearSelection() {
            selection = null;
            repaint();
        }

        protected void setSelection(Rectangle rectangle) {
            selection = rectangle;
            repaint();
        }
    }

}