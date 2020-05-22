import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

// ...

    public void solve() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen = env.getDefaultScreenDevice();
        Robot robot = null;
        try {
            robot = new Robot(screen);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        int lineNumber = 15;     // your line number

        try {
            Desktop.getDesktop().edit(new File(filename));
            Thread.sleep(100L);
            for (int i = 0; i < lineNumber; i++) {
                robot.keyPress(KeyEvent.VK_DOWN);
                Thread.sleep(10L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }