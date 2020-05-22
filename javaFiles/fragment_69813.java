import javax.swing.*;
import java.awt.*;

public class NullLayoutManagerWithJSlider extends JFrame {

    private JFrame frame = new JFrame();
    private static final long serialVersionUID = 1L;

    public NullLayoutManagerWithJSlider() {
        JSlider slider = new JSlider();
        slider.setPreferredSize(new Dimension(300, 30));        
        frame.setLayout(null);
        frame.add(slider);

        Insets mmInsets = frame.getInsets();
        Dimension sizeMmInn = null;
        slider.setPreferredSize(new Dimension(300, 30));
        sizeMmInn = slider.getPreferredSize();
        slider.setBounds(20 + mmInsets.left, 16 + mmInsets.top, sizeMmInn.width, sizeMmInn.height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.setSize(new Dimension(600, 400));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                NullLayoutManagerWithJSlider cf = new NullLayoutManagerWithJSlider();
            }
        });
    }
}