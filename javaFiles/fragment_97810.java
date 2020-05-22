import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class ChangePanelBackgroundNimbus {

    private JFrame frame = new JFrame();

    public ChangePanelBackgroundNimbus() {
        GradientPane pane = new GradientPane();
        pane.setLayout(new GridLayout(6, 4, 10, 10));
        for (int i = 1; i <= 24; i++) {
            pane.add(createButton(i));
        }
        pane.setOpaque(false);
        frame.add(pane);
        RepaintManager.setCurrentManager(new RepaintManager() {

            @Override
            public void addDirtyRegion(JComponent c, int x, int y, int w, int h) {
                Container con = c.getParent();
                while (con instanceof JComponent) {
                    if (!con.isVisible()) {
                        return;
                    }
                    if (con instanceof GradientPane) {
                        c = (JComponent) con;
                        x = 0;
                        y = 0;
                        w = con.getWidth();
                        h = con.getHeight();
                    }
                    con = con.getParent();
                }
                super.addDirtyRegion(c, x, y, w, h);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        //frame.setSize(400, 300);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton createButton(final int text) {
        JButton button = new JButton(Integer.toString(text));
        return button;
    }

    class GradientPane extends JPanel {

        private static final long serialVersionUID = 1L;
        private final int h = 150;
        private BufferedImage img = null;
        private BufferedImage shadow = new BufferedImage(1, h, BufferedImage.TYPE_INT_ARGB);

        public GradientPane() {
            paintBackGround(new Color(150, 250, 150));
            Timer t = new Timer(500, new ActionListener() {

                private Random r = new Random();

                @Override
                public void actionPerformed(ActionEvent e) {
                    paintBackGround(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
                }
            });
            t.start();
        }

        public void paintBackGround(Color g) {
            Graphics2D g2 = shadow.createGraphics();
            g2.setPaint(g);
            g2.fillRect(0, 0, 1, h);
            g2.setComposite(AlphaComposite.DstIn);
            g2.setPaint(new GradientPaint(0, 0, new Color(0, 0, 0, 0f), 0, h, new Color(0.4f, 0.8f, 0.8f, 0.5f)));
            g2.fillRect(0, 0, 1, h);
            g2.dispose();
        }

        @Override
        public void paintComponent(Graphics g) {
            if (img == null || img.getWidth() != getWidth() || img.getHeight() != getHeight()) {
                img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            }
            Graphics2D g2 = img.createGraphics();
            super.paintComponent(g2);
            Rectangle bounds = this.getVisibleRect();
            g2.scale(bounds.getWidth(), -1);
            g2.drawImage(shadow, bounds.x, -bounds.y - h, null);
            g2.scale(1, -1);
            g2.drawImage(shadow, bounds.x, bounds.y + bounds.height - h, null);
            g2.dispose();
            g.drawImage(img, 0, 0, null);
            repaint();
        }
    }

    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ChangePanelBackgroundNimbus ml = new ChangePanelBackgroundNimbus();
            }
        });
    }
}