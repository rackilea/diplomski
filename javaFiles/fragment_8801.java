import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ImageIcon ii = null;
                try {
                    //I dont remmend getScaledInstance just used it for speed of code writing
                    ii = new ImageIcon(ImageIO.read(new URL("http://www.candonetworking.com/java.gif")).getScaledInstance(32, 32, Image.SCALE_SMOOTH));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                MyLabel ml = new MyLabel(ii, "Something") {
                    @Override
                    void iconClicked() {
                        System.out.println("Icon clicked");
                    }

                    @Override
                    void textClicked() {
                        System.out.println("Text clicked");
                    }
                };

                frame.add(ml);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

abstract class MyLabel extends JPanel {

    JLabel iconLabel;
    JLabel textLabel;
    MouseAdapter iconMA;
    MouseAdapter textMA;

    public MyLabel(ImageIcon icon, String text) {
        iconLabel = new JLabel(icon);
        textLabel = new JLabel(text);
        iconMA = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                iconClicked();
            }
        };
        textMA = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                textClicked();
            }
        };
        iconLabel.addMouseListener(iconMA);
        textLabel.addMouseListener(textMA);
        add(iconLabel);
        add(textLabel);
    }

    abstract void iconClicked();

    abstract void textClicked();

    public JLabel getIconLabel() {
        return iconLabel;
    }

    public JLabel getTextLabel() {
        return textLabel;
    }
}