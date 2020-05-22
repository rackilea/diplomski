import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class JavaApplication142 extends JFrame {

    private int width = 300, height = 300;

    public JavaApplication142() {
        createAndShowUI();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JavaApplication142 jApp = new JavaApplication142();
            }
        });
    }

    private void createAndShowUI() {
        setTitle("Painting");
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addComponentsToContentPane(getContentPane());
        setVisible(true);
    }

    private void addComponentsToContentPane(Container contentPane) {
        Panel panel1 = new Panel();
        contentPane.add(panel1);
    }

    class Panel extends JPanel {

        private Random rand;

        public Panel() {
            rand = new Random();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < 25; i++) {
                g.drawString("string name", (int) rand.nextInt(width), (int) rand.nextInt(height));
                g.setColor(Color.RED);
            }
        }
    }
}