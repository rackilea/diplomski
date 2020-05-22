import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JLabel label;
        private FadingPane fadingPane;

        private File[] pictures;
        private int index;

        public TestPane() {
            // Just for show 
            setBackground(Color.RED);
            fadingPane = new FadingPane(new FadeListener() {
                @Override
                public void fadeDidStart(FadingPane panel) {
                }

                @Override
                public void fadeDidStop(FadingPane panel) {
                }

                @Override
                public void fadeOutDidComplete(FadingPane panel) {
                    nextPicture();
                    fadingPane.fadeIn();
                }

                @Override
                public void fadeInDidComplete(FadingPane panel) {
                }
            });
            setLayout(new BorderLayout());
            fadingPane.setLayout(new BorderLayout());
            label = new JLabel();
            fadingPane.add(label);

            add(fadingPane);

            JButton next = new JButton("Next");
            add(next, BorderLayout.SOUTH);
            next.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fadingPane.fadeOut();
                }
            });

            pictures = new File("/Volumes/Disk02/Dropbox/MegaTokyo/thumnails").listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    String name = pathname.getName().toLowerCase();
                    return name.endsWith(".jpg") || name.endsWith(".png");
                }
            });
            nextPicture();
        }

        protected void nextPicture() {
            index++;
            if (index >= pictures.length) {
                index = 0;
            }
            try {
                BufferedImage img = ImageIO.read(pictures[index]);
                label.setIcon(new ImageIcon(img));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public interface FadeListener {
        public void fadeDidStart(FadingPane panel);
        public void fadeDidStop(FadingPane panel);
        public void fadeOutDidComplete(FadingPane panel);
        public void fadeInDidComplete(FadingPane panel);
    }

    public class FadingPane extends JPanel {

        private float delta;
        private float alpha = 1f;
        private Timer timer;

        private FadeListener fadeListener;

        public FadingPane(FadeListener fadeListener) {
            this.fadeListener = fadeListener;
            // This is important, as we may not always be opaque
            // and we don't want to stuff up the painting process
            setOpaque(false);

            timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    float alpha = getAlpha() + delta;
                    if (alpha < 0.001f) {
                        alpha = 0f;
                        timer.stop();
                        fadeListener.fadeOutDidComplete(FadingPane.this);
                    } else if (alpha >= 1.0f) {
                        alpha = 1.0f;
                        timer.stop();
                        fadeListener.fadeInDidComplete(FadingPane.this);
                    }
                    setAlpha(alpha);
                }
            });
        }

        public float getAlpha() {
            return alpha;
        }

        public void setAlpha(float value) {
            if (alpha != value) {
                this.alpha = Math.min(1.0f, Math.max(0.0f, value));
                repaint();
            }
        }

        @Override
        public void paint(Graphics g) {
            // I don't normally recomamned overriding paint, but in this case,
            // I want to affect EVERYTHING that might be added to this panel
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(getAlpha()));
            super.paint(g2d);
            g2d.dispose();
        }

        public void fadeIn() {
            timer.stop();
            fadeListener.fadeDidStop(FadingPane.this);
            delta = 0.05f;
            timer.restart();
            fadeListener.fadeDidStart(FadingPane.this);
        }

        public void fadeOut() {
            timer.stop();
            fadeListener.fadeDidStop(FadingPane.this);
            delta = -0.05f;
            timer.restart();
            fadeListener.fadeDidStart(FadingPane.this);
        }

    }

}