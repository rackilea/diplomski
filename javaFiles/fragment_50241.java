import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class VideoEQFrame {

    public VideoEQFrame() {
        //constructor
    }

    public void show() {
        JFrame frame = new JFrame("Effects");

        JPanel panel = new JPanel();

        JPanel sliders= new JPanel();

        JPanel gainObjects = new JPanel(new BorderLayout());
        JSlider gainS = new JSlider(JSlider.VERTICAL, -12, 12, 0);

        gainS.setMajorTickSpacing(2);
        gainS.setPaintTicks(true);
        gainS.setToolTipText("Adjust the gain");
        JLabel gainL = new JLabel("Text");
        gainObjects.add(gainS, BorderLayout.CENTER);
        gainObjects.add(gainL, BorderLayout.PAGE_END);
        sliders.add(gainObjects);

        panel.add(sliders);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        //frame.setResizable(false);
        frame.setVisible(true);

//        Equalizer eq = new Equalizer(0);
//        return eq;
    }

    public static void main(final String[] args) {
        new VideoEQFrame().show();
    }
}