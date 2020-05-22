import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TestCursor {

    protected void initUI() throws MalformedURLException {
        JFrame frame = new JFrame("Test text pane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(new URL("http://fc03.deviantart.net/fs71/f/2010/094/7/9/Kalyan_hand_cursor_1_by_Zanten.png"));
        Point hotspot = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(image, hotspot, "Stone");
        frame.setCursor(cursor);

        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new TestCursor().initUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}