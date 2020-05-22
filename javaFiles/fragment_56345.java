import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ScalableImageExample {

    public static void main(String[] args) {
        new ScalableImageExample();
    }

    public ScalableImageExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    ResizableImagePane pane = new ResizableImagePane();
                    pane.setImage(...);

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(pane);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public class ResizableImagePane extends JPanel {

        private Image img;

        public ResizableImagePane() {
        }

        public void setImage(Image value) {
            if (img != value) {
                Image old = img;
                this.img = value;
                firePropertyChange("image", old, img);
                revalidate();
                repaint();
            }
        }

        public Image getImage() {
            return img;
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(this), img.getHeight(this));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Graphics2D g2d = (Graphics2D) g.create();

                int width = getWidth();
                int height = getHeight();

                double scaleFactor = getScaleFactorToFit(new Dimension(img.getWidth(this), img.getHeight(this)), getSize());

                int x = (int)((width - (img.getWidth(this) * scaleFactor)) / 2);
                int y = (int)((height - (img.getHeight(this) * scaleFactor)) / 2);

                AffineTransform at = new AffineTransform();
                at.translate(x, y);
                at.scale(scaleFactor, scaleFactor);
                g2d.setTransform(at);
                g2d.drawImage(img, 0, 0, this);
                g2d.dispose();
            }
        }

        public double getScaleFactor(int iMasterSize, int iTargetSize) {

            return (double) iTargetSize / (double) iMasterSize;

        }

        public double getScaleFactorToFit(Dimension original, Dimension toFit) {

            double dScale = 1d;

            if (original != null && toFit != null) {

                double dScaleWidth = getScaleFactor(original.width, toFit.width);
                double dScaleHeight = getScaleFactor(original.height, toFit.height);

                dScale = Math.min(dScaleHeight, dScaleWidth);

            }

            return dScale;

        }

    }

}