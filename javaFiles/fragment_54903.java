import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FrameByeBye {

    // The method we wish to call on exit.
    public static void showDialog(Component c) {
        JOptionPane.showMessageDialog(c, "Bye Bye!");
    }

    public static void main(String[] args) {
        // creating/udpating Swing GUIs must be done on the EDT.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                final JFrame f = new JFrame("Say Bye Bye!");
                // Swing's default behavior for JFrames is to hide them.
                f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                f.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent we) {
                        showDialog(f);
                        System.exit(0);
                    }
                } );
                f.setSize(300,200);
                f.setLocationByPlatform(true);
                f.setVisible(true);

            }
        });
    }
}