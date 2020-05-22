import javax.swing.JFrame;
import javax.swing.JLabel;

public class Annoying {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello!!");

        // Set's the window to be "always on top"
        frame.setAlwaysOnTop( true );

        frame.setLocationByPlatform( true );
        frame.add( new JLabel("  Isn't this annoying?") );
        frame.pack();
        frame.setVisible( true );
    }
}