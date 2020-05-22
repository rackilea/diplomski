import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.CellRendererPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Test {

    public Test() {
        createAndShowGui();
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame() {
            @Override
            public Dimension getPreferredSize() {//size frame purposefully smaller
                return new Dimension(100, 100);
            }
        };
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Image img = null;
        try {
            img = ImageIO.read(new URL("http://images4.wikia.nocookie.net/__cb20120515073660/naruto/images/0/09/Naruto_newshot.png")).getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        final ImagePanel imagePanel = new ImagePanel(200, 200, img);
        JScrollPane jsp = new JScrollPane(imagePanel);
        frame.add(jsp);


        frame.pack();
        frame.setVisible(true);
        BufferedImage bi = componentToImage(imagePanel, true);
        try {
            File outputfile = new File("c:/saved.png");
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static BufferedImage componentToImage(Component component, boolean visible) {
        if (visible) {
            BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TRANSLUCENT);
            Graphics2D g2d = (Graphics2D) img.getGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            component.paintAll(g2d);
            return img;
        } else {
            component.setSize(component.getPreferredSize());
            layoutComponent(component);
            BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TRANSLUCENT);
            CellRendererPane crp = new CellRendererPane();
            crp.add(component);
            crp.paintComponent(img.createGraphics(), component, crp, component.getBounds());
            return img;
        }
    }

    private static void layoutComponent(Component c) {
        synchronized (c.getTreeLock()) {
            c.doLayout();
            if (c instanceof Container) {
                for (Component child : ((Container) c).getComponents()) {
                    layoutComponent(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}

class ImagePanel extends JPanel {

    int width, height;
    Image bg;

    public ImagePanel(int width, int height, Image bg) {
        this.width = width;
        this.height = height;
        this.bg = bg;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.drawImage(bg, 0, 0, null);
    }
}