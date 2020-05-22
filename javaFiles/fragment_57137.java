import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        protected static final int[][] MAP
                = {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1}
                };
        protected static Dimension GRID_SIZE = new Dimension(20, 20);
        private BufferedImage buf; // This represents your image

        public TestPane() {
            int max = 0;
            for (int row = 0; row < MAP.length; row++) {
                max = Math.max(max, MAP[row].length);
            }

            setLayout(new GridBagLayout());

            buf = makeBuffer();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 0;
            for (int row = 0; row < MAP.length; row++) {
                gbc.gridx = 0;
                for (int col = 0; col < MAP[row].length; col++) {
                    add(new JLabel(new ImageIcon(buf)), gbc);
                    gbc.gridx++;
                }
                gbc.gridy++;
            }
        }

        protected BufferedImage makeBuffer() {
            BufferedImage img = new BufferedImage(GRID_SIZE.width, GRID_SIZE.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawRect(0, 0, img.getWidth() - 1, img.getHeight() - 1);
            g2d.dispose();
            return img;
        }

    }
}