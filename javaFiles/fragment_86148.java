import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
                frame.add(new DrawPane("/Volumes/Disk02/Dropbox/MegaTokyo/thumnails/0.jpg"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ImagePanel extends JPanel {

        private Image img;

        public ImagePanel(String img, String str) {
            //this(new ImageIcon(img).getImage());    
        }

        public ImagePanel(String path) {
            Image img = new ImageIcon(path).getImage();
            this.img = img;
            try {
                BufferedImage image = ImageIO.read(new File(path));
                int rgb = image.getRGB(66, 52);
                System.out.println("Colour is: " + rgb);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(this), img.getHeight(this));          
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, null);
        }
    }

    public class DrawPane extends ImagePanel {

        private List<Shape> shapes;

        public DrawPane(String img, String str) {
            super(img, str);
            init();
        }

        public DrawPane(String path) {
            super(path);
            init();
        }

        protected void init() {
            shapes = new ArrayList<>(25);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    boolean clicked = false;
                    Iterator<Shape> it = shapes.iterator();
                    while (it.hasNext()) {
                        Shape shape = it.next();
                        if (shape.contains(e.getPoint())) {
                            it.remove();
                            clicked = true;
                            break;
                        }
                    }
                    if (!clicked) {
                        shapes.add(new Ellipse2D.Double(e.getX() - 10, e.getY() - 10, 20, 20));
                    }
                    repaint();
                }

            });
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); 
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            for (Shape shape : shapes) {
                g2d.draw(shape);
            }
            g2d.dispose();
        }

    }

}