import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ClickMyImages {

    public static void main(String[] args) {
        new ClickMyImages();
    }

    public ClickMyImages() {
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

    public class TestPane extends JLayeredPane {

        public TestPane() {
            try {
                BufferedImage img1 = ImageIO.read("/Image1");
                BufferedImage img2 = ImageIO.read("/Image2");
                BufferedImage img3 = ImageIO.read("/Image3");
                BufferedImage img4 = ImageIO.read("/Image4");
                BufferedImage img5 = ImageIO.read("/Image5");

                JLabel label1 = new ClickableLabel(new ImageIcon(img1));
                JLabel label2 = new ClickableLabel(new ImageIcon(img2));
                JLabel label3 = new ClickableLabel(new ImageIcon(img3));
                JLabel label4 = new ClickableLabel(new ImageIcon(img4));
                JLabel label5 = new ClickableLabel(new ImageIcon(img5));

                Dimension masterSize = getPreferredSize();

                Dimension size = label1.getPreferredSize();
                label1.setBounds((masterSize.width - size.width) / 2, (masterSize.height - size.height) / 2, size.width, size.height);
                Point masterPoint = label1.getLocation();
                size = label2.getPreferredSize();
                label2.setBounds(
                        masterPoint.x - (size.width / 2), 
                        masterPoint.y - (size.height  / 2), 
                        size.width, size.height);
                size = label3.getPreferredSize();
                label3.setBounds(
                        masterPoint.x + (size.width / 2), 
                        masterPoint.y - (size.height  / 2), 
                        size.width, size.height);
                size = label4.getPreferredSize();
                label4.setBounds(
                        masterPoint.x - (size.width / 2), 
                        masterPoint.y + (size.height  / 2), 
                        size.width, size.height);
                size = label5.getPreferredSize();
                label5.setBounds(
                        masterPoint.x + (size.width / 2), 
                        masterPoint.y + (size.height  / 2), 
                        size.width, size.height);

                add(label1);
                add(label2);
                add(label3);
                add(label4);
                add(label5);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 800);
        }
    }

    // This is for demonstration purposes only!
    public class ClickableLabel extends JLabel {

        private boolean isIn = false;

        public ClickableLabel(Icon image) {
            super(image);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    isIn = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    isIn = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (isIn) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                g2d.setColor(Color.RED);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        }
    }
}