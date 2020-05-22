import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @see https://stackoverflow.com/q/10208255/230513
 * @see https://stackoverflow.com/questions/5838842
 * @see https://stackoverflow.com/questions/5864490
 */
public class RescaleTest extends JPanel implements ChangeListener {

    private static final String NAME = "image.jpg";
    private BufferedImage image, copy;
    private JSlider slider = new JSlider();

    public RescaleTest() {
        PlanarImage pi = JAI.create("fileload", NAME);
        image = pi.getAsBufferedImage();
        copy = pi.getAsBufferedImage();
        this.setLayout(new BorderLayout());
        this.add(new JLabel(new ImageIcon(copy)));
        this.add(slider, BorderLayout.SOUTH);
        slider.setValue(slider.getMaximum() / 2);
        slider.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        float value = (float) slider.getValue();
        float scaleFactor = 2 * value / slider.getMaximum();
        RescaleOp op = new RescaleOp(scaleFactor, 0, null);
        copy = op.filter(image, copy);
        repaint();
    }

    private void display() {
        JFrame f = new JFrame("RescaleTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new RescaleTest().display();
            }
        });
    }
}