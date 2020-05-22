import java.awt.event.*;
import javax.swing.*;

public class ChangeIcon {

    public ChangeIcon() {
        final ImageIcon image = new ImageIcon("image.jpg");
        final ImageIcon image1 = new ImageIcon("image1.jpg");
        final JLabel iconLabel = new JLabel(image);

        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iconLabel.setIcon(image1);
            }
        });
        timer.setRepeats(false);
        timer.start();

        JFrame frame = new JFrame();
        frame.add(iconLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChangeIcon();
            }
        });
    }
}