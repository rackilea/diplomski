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

public class ClickMyDrawnImages {

    public static void main(String[] args) {
        new ClickMyDrawnImages();
    }

    public ClickMyDrawnImages() {
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

        private BufferedImage tree;
        private BufferedImage squirrel;
        private BufferedImage mouseOver;

        public TestPane() {
            try {
                tree = ImageIO.read(new File("Tree.png"));
                squirrel = ImageIO.read(new File("Squirrel.png"));
            } catch (IOException exp) {
                exp.printStackTrace();
            }
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if (withinTree(e.getPoint())) {
                        mouseOver = tree;
                    } else if (withinSquirrel(e.getPoint())) {
                        mouseOver = squirrel;
                    } else {
                        mouseOver = null;
                    }
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected boolean withinTree(Point p) {
            return withinBounds(p, getTreeBounds(), tree);
        }

        protected boolean withinSquirrel(Point p) {
            return !withinBounds(p, getTreeBounds(), tree) && withinBounds(p, getSquirrelBounds(), squirrel);
        }

        protected Rectangle getTreeBounds() {
            int width = getWidth();
            int height = getHeight();

            int x = (width - tree.getWidth()) / 2;
            int y = (height - tree.getHeight()) / 2;

            return new Rectangle(x, y, tree.getWidth(), tree.getHeight());
        }

        protected Rectangle getSquirrelBounds() {
            Rectangle bounds = getTreeBounds();

            return new Rectangle(
                    bounds.x - (squirrel.getWidth() / 4),
                    (getHeight() - squirrel.getHeight()) / 2,
                    squirrel.getWidth(), squirrel.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int width = getWidth();
            int height = getHeight();

            int x = (width - tree.getWidth()) / 2;
            int y = (height - tree.getHeight()) / 2;

            g.drawImage(highlight(squirrel), x - (squirrel.getWidth() / 4), (height - squirrel.getHeight()) / 2, this);
            g2d.drawImage(highlight(tree), x, y, this);

            g2d.dispose();
        }

        protected BufferedImage highlight(BufferedImage img) {
            BufferedImage highlight = img;
            if (img.equals(mouseOver)) {
                highlight = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = highlight.createGraphics();
                g2d.setColor(Color.RED);
                g2d.drawImage(img, 0, 0, this);

                g2d.setComposite(AlphaComposite.SrcAtop.derive(0.5f));
                g2d.fillRect(0, 0, highlight.getWidth(), highlight.getHeight());
                g2d.dispose();
            }
            return highlight;
        }

        protected boolean withinBounds(Point p, Rectangle bounds, BufferedImage image) {
            boolean withinBounds = false;
            if (bounds.contains(p)) {
                int x = p.x - bounds.x;
                int y = p.y - bounds.y;
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xFF;
                // could use a little weighting, so translucent pixels can be effected
                if (a == 255) {
                    withinBounds = true;
                }
            }
            return withinBounds;
        }
    }
}