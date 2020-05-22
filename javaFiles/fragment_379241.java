import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;

// an applet class must extend either Applet or JApplet
public class AppletTest extends JApplet {

    // it should have an init() method where it holds its initialization code.
    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    add(new DrawingPanel());
                }
            });
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// avoid drawing directly within the applet itself
// but instead draw within a JPanel that is added to the applet
class DrawingPanel extends JPanel {

    // this is the method to draw in
    @Override
    protected void paintComponent(Graphics g) {
        // don't forget to call the super method to do "housekeeping" drawing
        super.paintComponent(g);
        g.drawLine(0, 0, 200, 200);
    }
}