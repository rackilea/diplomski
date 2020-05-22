import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Test {
    // position, where mouse should stay
    private static final int fixX = 500;
    private static final int fixY = 500;

    private static Robot robo;
    private static JFrame frame;

    public static void main(String[] args) {
        // create robot
        try {
            robo = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // create default frame with mouse listener
        frame = new JFrame("test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                move(arg0);
            }

            @Override
            public void mouseMoved(MouseEvent arg0) {
                move(arg0);
            }
        });
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }

    private static void move(MouseEvent arg0) {
        // check, if action was thrown by robot
        if (arg0.getX() == fixX && arg0.getY() == fixY) {
            // ignore mouse action
            return;
        }
        // move mouse to center (important: position relative to frame!)
        robo.mouseMove(fixX + frame.getX(), fixY + frame.getY());

        // compute and print move position
        int moveX = arg0.getX() - fixX;
        int moveY = arg0.getY() - fixY;
        System.out.println("moved: " + moveX + " " + moveY);
    }
}