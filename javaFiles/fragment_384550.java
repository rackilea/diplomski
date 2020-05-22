import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("TheDlooter");
        frame.setFullscreenMode(1);
        frame.setVisible(true);
    }
}

class Frame extends JFrame {

    boolean fse = false;
    int fsm = 0;
    GraphicsDevice device =
    GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1];

    public Frame(String title) {
        setTitle(title);

        add(new JLabel("ads"));

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void setVisible(boolean b) {
        checkFullscreenMode();
        super.setVisible(b);
    }

    public void checkFullscreenMode() {
        switch (fsm) {
        case 0:
            setUndecorated(false);
            System.out.println("No Fullscreen");
            break;
        case 1:
            setUndecorated(true);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            break;
        case 2:
            setUndecorated(true);
            device.setFullScreenWindow(this);
            break;
        }
    }

    public void setFullscreenMode(int fsnm) {
        fse = true;
        if (fsm <= 2) {
            this.fsm = fsnm;
        } else {
            System.err.println("Error: Mode " + fsnm + " is not Supported!");
        }
    }
}