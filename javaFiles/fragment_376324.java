import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

public class NestJPanels {

    ImageIcon icon;

    public NestJPanels() {
        try {
            icon = new ImageIcon(new URL("http://sstatic.net/programmers/img/apple-touch-icon.png"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(NestJPanels.class.getName()).log(Level.SEVERE, null, ex);
        }

        Box box = Box.createVerticalBox();
        for (int i = 0; i < 4; i++) {
            box.add(Box.createVerticalStrut(10));
            box.add(new JButton("Button"));
        }

        JPanel imagePanel = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel(icon);
            label.setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
            label.setText("StackOverflow");
            imagePanel.add(label);
        }

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(box, BorderLayout.WEST);
        panel.add(imagePanel);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(NestJPanels.class.getName()).log(Level.SEVERE, null, ex);
                }
                new NestJPanels();
            }
        });
    }
}