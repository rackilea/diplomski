import java.awt.Cursor;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("test");
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            JButton normal = new JButton("Normal");
            JButton gif = new JButton("GIF");
            JButton png = new JButton("PNG");

            add(normal);
            add(gif);
            add(png);

            normal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setCursor(Cursor.getDefaultCursor());
                }
            });

            gif.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    try {
//                        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/images/cursor.gif"));
//                        MediaTracker mt = new MediaTracker(TestPane.this);
//                        mt.addImage(image, 1);
//                        mt.waitForAll();
//                        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "gifCursor");
//                        
//                        setCursor(cursor);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    try {
                        Image image = ImageIO.read(getClass().getResource("/images/cursor.gif"));
                        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "gifCursor");

                        setCursor(cursor);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            png.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Image image = ImageIO.read(getClass().getResource("/images/cursor.png"));
                        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "pngCursor");

                        setCursor(cursor);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

    }

}