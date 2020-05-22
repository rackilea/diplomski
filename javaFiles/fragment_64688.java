import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
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
                frame.add(new VolmeControlPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class VolmeControlPane extends JPanel {

        protected static final int VOLUME_MIN = 0;
        protected static final int VOLUME_MAX = 100;
        protected static final String SLIDER_CONTROL_KEY = "Slider.controlKey";

        public VolmeControlPane() {
            setLayout(new GridBagLayout());
            JSlider[] sliders = makeSliders(16);
            for (JSlider slider : sliders) {
                add(slider);
            }
        }

        public JSlider[] makeSliders(int count) {

            JSlider[] sliders = new JSlider[count];
            for (int index = 0; index < count; index++) {
                sliders[index] = makeSlider(VOLUME_MIN, VOLUME_MAX, VOLUME_MIN + (VOLUME_MAX / 2));
                sliders[index].putClientProperty(SLIDER_CONTROL_KEY, index);
            }

            return sliders;

        }

        public JSlider makeSlider(int min, int max, int value) {
            JSlider volumeControl = new JSlider(JSlider.VERTICAL,
                            min, max, value);

            volumeControl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

            return volumeControl;
        }

    }

}