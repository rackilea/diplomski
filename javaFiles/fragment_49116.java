import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            try {
                JLabel background = new JLabel(new ImageIcon(ImageIO.read(...)));
                background.setLayout(new BorderLayout());
                JLabel text = new JLabel("I'm just drawn this way");
                text.setFont(text.getFont().deriveFont(128f));
                text.setHorizontalAlignment(JLabel.RIGHT);
                text.setVerticalAlignment(JLabel.BOTTOM);
                text.setForeground(Color.WHITE);

                background.add(text);

                add(background);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}