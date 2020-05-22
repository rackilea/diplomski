import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ClickTest {

    public static void main(String[] args) {
        new ClickTest();
    }

    public ClickTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JLabel[][] casesArray;

        public TestPane() {

            setLayout(new GridLayout(0, 6));

            File[] files = new File("/path/to/lots/of/images").listFiles();

            MouseListener listener = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    Object source = event.getSource();
                    for (int x = 0; x < casesArray.length; x++) {
                        for (int y = 0; y < casesArray[x].length; y++) {
                            if (casesArray[x][y] == source) {
                                casesArray[x][y].setIcon(null);
                                break;
                            }
                        }
                    }
                }
            };

            casesArray = new JLabel[6][6];
            int index = 0;
            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 6; y++) {
                    JLabel label = new JLabel();
                    try {
                        label.setIcon(new ImageIcon(ImageIO.read(files[index++])));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    label.addMouseListener(listener);
                    casesArray[x][y] = label;
                    add(casesArray[x][y]);
                }
            }
        }
    }
}