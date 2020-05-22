import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

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

                BackgroundPane bp = new BackgroundPane();
                bp.setLayout(new BorderLayout());
                bp.setBorder(new EmptyBorder(20, 20, 20, 20));

                SeeThroughTabbedPane tp = new SeeThroughTabbedPane();
                tp.setAlpha(0.5f);
                tp.addTab("Tab 1", new TestPane("I be see through"));
                tp.addTab("Tab 2", new TestPane("But you can't see me"));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(bp);
                frame.add(tp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane(String text) {
            setOpaque(false);
            setLayout(new GridBagLayout());
            JLabel label = new JLabel(text);
            label.setForeground(Color.WHITE);
            add(label);
        }

    }

    public class BackgroundPane extends JPanel {

        private BufferedImage bg;

        public BackgroundPane() {
            try {
                bg = ImageIO.read(new File("/Volumes/Disk02/Dropbox/MegaTokyo/megatokyo_omnibus_1_3_cover_by_fredrin-d4oupef 50%.jpg"));
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
            if (bg != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - bg.getWidth()) / 2;
                int y = (getHeight() - bg.getHeight()) / 2;
                g2d.drawImage(bg, x, y, this);
                g2d.dispose();
            }
        }

    }

    public class SeeThroughTabbedPane extends JTabbedPane {

        private float alpha;

        public SeeThroughTabbedPane() {
            setOpaque(false);
            setAlpha(1f);
        }

        public void setAlpha(float value) {
            if (alpha != value) {
                float old = alpha;
                this.alpha = value;
                firePropertyChange("alpha", old, alpha);
                repaint();
            }
        }

        public float getAlpha() {
            return alpha;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getBackground());
            g2d.setComposite(AlphaComposite.SrcOver.derive(getAlpha()));
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
            super.paintComponent(g);
        }

    }

}