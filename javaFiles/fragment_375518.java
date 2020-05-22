import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
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
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    TimeOutPane tp = new TimeOutPane();
                    tp.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            tp.executeTimeout();
                        }
                    });

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(tp);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class TimeOutPane extends JPanel {

        private BufferedImage background;
        private float progress = 0;
        private long startedAt;
        private int timeout = 5000;

        private Timer timer;

        public TimeOutPane() throws IOException {
            background = ImageIO.read(new File("/Volumes/Disk02/Dropbox/Ponies/url.png"));
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }

        public int getTimeout() {
            return timeout;
        }

        public void setProgress(float progress) {
            this.progress = progress;
            repaint();
        }

        public float getProgress() {
            return progress;
        }

        public void executeTimeout() {
            if (timer == null) {
                timer = new Timer(40, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        long diff = System.currentTimeMillis() - startedAt;
                        float progress = diff / (float) timeout;
                        if (diff >= timeout) {
                            progress = 1f;
                            timer.stop();
                        }
                        setProgress(progress);
                    }
                });
            } else if (timer.isRunning()) {
                timer.stop();
            }

            startedAt = System.currentTimeMillis();
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? new Dimension(200, 200) : new Dimension(background.getWidth(), background.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                applyQualityRenderingHints(g2d);
                int x = (getWidth() - background.getWidth()) / 2;
                int y = (getHeight() - background.getHeight()) / 2;
                g2d.drawImage(background, x, y, this);

                g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                g2d.setColor(Color.BLACK);

                int radius = Math.max(getWidth(), getHeight()) / 2;

                g2d.fillArc(-radius, -radius, radius * 4, radius * 4, 90, (int) (360f * (1f - progress)));

                g2d.dispose();
            }
        }

        public void applyQualityRenderingHints(Graphics2D g2d) {
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        }

    }

}