import java.awt.BorderLayout;
import java.lang.reflect.Field;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SliderDemo {

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("javax.swing.plaf.synth.SynthLookAndFeel");

        Class<?> sliderUIClass = Class.forName("javax.swing.plaf.synth.SynthSliderUI");
        final Field paintValue = sliderUIClass.getDeclaredField("paintValue");
        paintValue.setAccessible(true);

        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLayout(new BorderLayout());

                JSlider slider = new JSlider(3, 6, 4);
                try {
                    paintValue.set(slider.getUI(), false);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                f.add(slider, BorderLayout.CENTER);

                f.pack();
                f.setVisible(true);
            }
        });
    }

}