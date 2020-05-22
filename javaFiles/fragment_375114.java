import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    }

                    BufferedImage img = ImageIO.read(new File("C:\\hold\\thumbnails\\MT015.jpg"));
                    final ImagePanel imgPane = new ImagePanel(img);
                    JScrollPane scrollPane = new JScrollPane(imgPane);
                    final JLabel report = new JLabel("...");

                    imgPane.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            Point panelPoint = e.getPoint();
                            Point imgContext = imgPane.toImageContext(panelPoint);

                            report.setText("You clicked at " + panelPoint + " which is relative to the image " + imgContext);
                        }
                    });

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(scrollPane);
                    frame.add(report, BorderLayout.SOUTH);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public class ImagePanel extends JPanel {

        private BufferedImage img;

        public ImagePanel(BufferedImage img) {
            this.img = img;
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? super.getPreferredSize() : new Dimension(img.getWidth(), img.getHeight());
        }

        protected Point getImageLocation() {

            Point p = null;
            if (img != null) {
                int x = (getWidth() - img.getWidth()) / 2;
                int y = (getHeight() - img.getHeight()) / 2;
                p = new Point(x, y);
            }
            return p;

        }

        public Point toImageContext(Point p) {
            Point imgLocation = getImageLocation();
            Point relative = new Point(p);
            relative.x -= imgLocation.x;
            relative.y -= imgLocation.y;
            return relative;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Point p = getImageLocation();
                g.drawImage(img, p.x, p.y, this);
            }
        }

    }

}