import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MovingBackgroundDemo {

    public MovingBackgroundDemo() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new AnimatingPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class AnimatingPanel extends JPanel {
        private static final int DIM_W = 350;
        private static final int DIM_H = 350;
        private static final int INCREMENT = 10;

        private BufferedImage backgroundImage;
        private Image runnerImage;

        private int dx1, dy1, dx2, dy2;
        private int srcx1, srcy1, srcx2, srcy2;
        private int IMAGE_WIDTH;

        public AnimatingPanel() {
            initImages();
            initImagePoints();
            Timer timer = new Timer(40, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    moveBackground();
                    repaint();
                }
            });
            timer.start();

            FlowLayout layout = (FlowLayout)getLayout();
            layout.setHgap(0);
            layout.setVgap(0);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(backgroundImage, dx1, dy1, dx2, dy2, srcx1, srcy1,
                    srcx2, srcy2, this);
            g.drawImage(runnerImage, 0, 0, getWidth(), getHeight(), this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(350, 350);
        }

        private void initImagePoints() {
            dx1 = 0;
            dy1 = 0;
            dx2 = DIM_W;
            dy2 = DIM_H;
            srcx1 = 0;
            srcy1 = 0;
            srcx2 = DIM_W;
            srcy2 = DIM_H;
        }

        private void initImages() {
            try {
                runnerImage = new ImageIcon(getClass().getResource("runner.gif")).getImage();
                backgroundImage = ImageIO.read(getClass().getResource(
                        "background.png"));
                IMAGE_WIDTH = backgroundImage.getWidth();
                System.out.println(IMAGE_WIDTH);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void moveBackground() {
            if (srcx1 > IMAGE_WIDTH) {
                srcx1 = 0 - DIM_W;
                srcx2 = 0;
            } else {
                srcx1 += INCREMENT;
                srcx2 += INCREMENT;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MovingBackgroundDemo();
            }
        });
    }
}