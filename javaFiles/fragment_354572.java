import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JSlider;
import javax.swing.plaf.metal.MetalSliderUI;

public class MetalSnapSliderUI extends MetalSliderUI {

    private MouseMotionListener myMouseMotionListener = new MouseMotionListener() {

        public void mouseDragged(MouseEvent e) {
            trackListener.mouseDragged(e);
            calculateThumbLocation();
            slider.repaint();
        }

        public void mouseMoved(MouseEvent e) {
            trackListener.mouseMoved(e);
        }

    };

    @Override
    protected void installListeners(JSlider slider) {
        super.installListeners(slider);
        slider.removeMouseMotionListener(trackListener);
        slider.addMouseMotionListener(myMouseMotionListener);
    }

    @Override
    protected void uninstallListeners(JSlider slider) {
        super.uninstallListeners(slider);
        slider.removeMouseMotionListener(myMouseMotionListener);
    }

}