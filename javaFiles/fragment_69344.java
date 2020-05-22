import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.ToolTipManager;

public class TestTooltips {

    protected static void initUI() {
        JFrame frame = new JFrame("test");
        final JLabel label = new JLabel("Label text");
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
        Timer t = new Timer(1000, new ActionListener() {

            int progress = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (progress > 100) {
                    progress = 0;
                }
                label.setToolTipText("Progress: " + progress + " %");
                Point locationOnScreen = MouseInfo.getPointerInfo().getLocation();
                Point locationOnComponent = new Point(locationOnScreen);
                SwingUtilities.convertPointFromScreen(locationOnComponent, label);
                if (label.contains(locationOnComponent)) {
                    ToolTipManager.sharedInstance().mouseMoved(
                            new MouseEvent(label, -1, System.currentTimeMillis(), 0, locationOnComponent.x, locationOnComponent.y,
                                    locationOnScreen.x, locationOnScreen.y, 0, false, 0));
                }
                progress++;
            }
        });
        t.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                initUI();
            }
        });
    }
}