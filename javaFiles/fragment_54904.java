import java.awt.*;
import java.awt.event.*;

class FrameByeBye {

    // The method we wish to call on exit.
    public static void showMessage() {
        System.out.println("Bye Bye!");
    }

    public static void main(String[] args) {
        Frame f = new Frame("Say Bye Bye!");
        f.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                showMessage();
                System.exit(0);
            }
        } );
        f.setSize(300,200);
        f.setLocationByPlatform(true);
        f.setVisible(true);
    }
}