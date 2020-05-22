import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class HiRes {

    public static void main(String[] args) {
        new HiRes();
    }

    public HiRes() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final TestPane tp = new TestPane();
                JButton print = new JButton("Print");
                print.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Dimension original = tp.getSize();

                        System.out.println("Original = " + original);

                        int width = tp.getWidth() * 4;
                        int height = tp.getHeight() * 4;

                        System.out.println("Target = " + width + "x" + height);
                        tp.setSize(width, height);
                        tp.doLayout();
                        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g2d = img.createGraphics();
                        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
                        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
                        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
//                      g2d.setTransform(AffineTransform.getScaleInstance(4, 4));
                        tp.print(g2d);
                        g2d.dispose();
                        tp.setSize(original);
                        tp.doLayout();

                        try {
                            ImageIO.write(img, "png", new File("Test.png"));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(tp);
                frame.add(print, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage background;

        public TestPane() {

            setLayout(new GridBagLayout());

            try {
                background = ImageIO.read(new File("/some/image/some/where"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            setLayout(new GridBagLayout());

            JLabel label = new JLabel("This is a test");
            label.setForeground(Color.WHITE);
            label.setFont(label.getFont().deriveFont(24f));
            add(label);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                Image scaled = background;
                if (getWidth() < getHeight()) {
                    scaled = background.getScaledInstance(getWidth(), -1, Image.SCALE_SMOOTH);
                } else {
                    scaled = background.getScaledInstance(-1, getHeight(), Image.SCALE_SMOOTH);
                }
                int x = (getWidth() - scaled.getWidth(this)) / 2;
                int y = (getHeight() - scaled.getHeight(this)) / 2;
                g2d.drawImage(scaled, x, y, this);
                g2d.dispose();
            }
        }

    }

}