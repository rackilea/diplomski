import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class ScalingTest {

    public static void main(String[] args) {
        new ScalingTest();
    }

    public ScalingTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                ImagePane pane = new ImagePane();
                JButton btn = new JButton("Scale");
                JSlider slider = new JSlider(10, 300);
                slider.setMinorTickSpacing(5);
                slider.setMajorTickSpacing(10);
                slider.setSnapToTicks(true);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            float scale = slider.getValue() / 100f;
                            Dimension size = pane.getSize();
                            System.out.println("Original = " + size);
                            size.width *= scale;
                            size.height *= scale;
                            System.out.println("Scaled = " + size);
                            BufferedImage scaled = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
                            Graphics2D g2d = scaled.createGraphics();
                            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
                            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
                            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
                            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
                            g2d.scale(scale, scale);
                            pane.printAll(g2d);
                            g2d.dispose();

                            ImageIO.write(scaled, "png", new File("Scaledx" + scale + ".png"));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                JPanel panel = new JPanel(new GridLayout(2, 1));
                panel.add(slider);
                panel.add(btn);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(pane);
                frame.add(panel, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ImagePane extends JPanel {

        private BufferedImage bg;

        public ImagePane() {
            try {
                bg = ImageIO.read(new File("/Volumes/Disk02/Dropbox/MegaTokyo/issue194.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return bg == null ? new Dimension(200, 200) : new Dimension(bg.getWidth(), bg.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g2d.drawImage(bg, x, y, this);
            g2d.dispose();
        }

    }

}