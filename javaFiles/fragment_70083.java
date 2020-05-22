import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DisplayModeChanger extends JFrame {

    private GraphicsDevice device;
    private static JButton changeDM = new JButton("800X600 @ 32 BIT 60HZ");
    private boolean isFullScreenSupported = false;

    public DisplayModeChanger(final GraphicsDevice device) {

        this.device = device;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        changeDM.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DisplayMode dm = new DisplayMode(800, 600, 32, 60);
                device.setDisplayMode(dm);
                setSize(new Dimension(dm.getWidth(), dm.getHeight()));
                validate();
            }
        });

    }

    public void goFullScreen() {
        isFullScreenSupported = device.isFullScreenSupported();
        setUndecorated(isFullScreenSupported);
        setResizable(!isFullScreenSupported);
        if (isFullScreenSupported) {
            device.setFullScreenWindow(this);
            validate();
        } else {
            pack();
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = env.getDefaultScreenDevice();
        DisplayModeChanger changer = new DisplayModeChanger(defaultScreen);
        changer.getContentPane().add(changeDM);
        changer.goFullScreen();
    }
}