import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SkewImage {

    public static void main(String[] args) {
        new SkewImage();
    }

    public SkewImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridLayout(1, 2));
            try {
                BufferedImage original = ImageIO.read(new File("C:\\hold\\thumbnails\\Megatokyo_707___Torn_by_crusaderky.jpg"));
                BufferedImage skew = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);

                // Adjust the image width if we use a negative skew...
                double skewX = 0.3d;
                double x = (skewX < 0) ? -skewX * original.getHeight() : 0;
                AffineTransform at = AffineTransform.getTranslateInstance(x, 0);
                at.shear(skewX, 0);
                AffineTransformOp op = new AffineTransformOp(at,
                        new RenderingHints(RenderingHints.KEY_INTERPOLATION,
                                RenderingHints.VALUE_INTERPOLATION_BICUBIC));
                skew = op.filter(original, null);

                add(new JLabel(new ImageIcon(original)));
                add(new JLabel(new ImageIcon(skew)));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}