import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test{

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

        private BufferedImage sky, mountains, tree;
        private List<Point> treePoints;

        public TestPane() {
            try {
                sky = ImageIO.read(getClass().getResource("/Sky.png"));
                mountains = ImageIO.read(getClass().getResource("/Mountians.png"));
                tree = ImageIO.read(getClass().getResource("/Tree.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            treePoints = new ArrayList<>(25);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.anchor = gbc.SOUTH;

            JSlider slider = new JSlider(0, 1000);
            slider.setValue(0);
            add(slider, gbc);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int count = slider.getValue();
                    if (count == 0) {
                        treePoints.clear();
                    } else if (count < treePoints.size()) {
                        treePoints = treePoints.subList(0, count - 1);
                    } else {

                        Rectangle skyBounds = getSkyBounds();
                        int y = (skyBounds.y + skyBounds.height) - tree.getHeight();
                        while (treePoints.size() < count) {

                            int x = skyBounds.x + (int)Math.round((Math.random() * (skyBounds.width + tree.getWidth()))) - tree.getWidth();
                            treePoints.add(new Point(x, y));

                        }

                    }
                    repaint();
                }
            });
        }

        protected Rectangle getSkyBounds() {

            int x = (getWidth() - sky.getWidth()) / 2;
            int y = (getHeight() - sky.getHeight()) / 2;

            return new Rectangle(x, y, sky.getWidth(), sky.getHeight());

        }

        @Override
        public Dimension getPreferredSize() {
            return sky == null ? new Dimension(200, 200) : new Dimension(sky.getWidth(), sky.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            Rectangle skyBounds = getSkyBounds();

            g2d.drawImage(sky, skyBounds.x, skyBounds.y, this);
            g2d.drawImage(mountains, 
                            skyBounds.x, 
                            skyBounds.y + skyBounds.height - (mountains.getHeight()), 
                            this);

            for (Point p : treePoints) {
                g2d.drawImage(tree, p.x, p.y, this);
            }

            g2d.dispose();
        }

    }

}