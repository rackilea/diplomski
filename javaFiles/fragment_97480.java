package overflow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/** @see http://stackoverflow.com/questions/7298492 */
public class PiRaster extends JPanel {

    private static final int W = 30;
    private static final int H = 30;
    private static List<Integer> pi = new ArrayList<Integer>();
    private final List<Integer> clut = new ArrayList<Integer>();
    private BufferedImage image;

    public PiRaster() {
        this.setPreferredSize(new Dimension(W * 16, H * 10));
        String s = ""
            + "31415926535897932384626433832795028841971693993751"
            + "05820974944592307816406286208998628034825342117067"
            + "98214808651328230664709384460955058223172535940812"
            + "84811174502841027019385211055596446229489549303819"
            + "64428810975665933446128475648233786783165271201909"
            + "14564856692346034861045432664821339360726024914127";
        for (int i = 0; i < s.length(); i++) {
            pi.add(s.charAt(i) - '0');
        }
        for (int i = 0; i < 10; i++) {
            clut.add(Color.getHSBColor(0.6f, i / 10f, 1).getRGB());
        }
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        int i = 0;
        for (int row = 0; row < H; row++) {
            for (int col = 0; col < W; col++) {
                image.setRGB(col, row, clut.get(pi.get(i)));
                if (++i == pi.size()) {
                    i = 0;
                }
            }
        }
    }

    private static class ClutPanel extends JPanel {

        private int i;

        public ClutPanel(List<Integer> rgbList) {
            this.setLayout(new GridLayout(1, 0));
            for (Integer rgb : rgbList) {
                JLabel label = new JLabel(String.valueOf(i++), JLabel.CENTER);
                label.setOpaque(true);
                label.setBackground(new Color(rgb));
                this.add(label);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                PiRaster pr = new PiRaster();
                Icon icon = new ImageIcon(pr.image);
                frame.add(new JLabel(icon), BorderLayout.WEST);
                frame.add(pr, BorderLayout.CENTER);
                frame.add(new ClutPanel(pr.clut), BorderLayout.SOUTH);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}